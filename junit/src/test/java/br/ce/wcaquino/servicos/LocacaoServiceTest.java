package br.ce.wcaquino.servicos;

import static br.ce.wcaquino.builders.FilmeBuilder.umFilme;
import static br.ce.wcaquino.builders.LocacaoBuilder.umLocacao;
import static br.ce.wcaquino.builders.UsuarioBuilder.umUsuario;
import static br.ce.wcaquino.matchers.MatchersProprios.caiNumaSegunda;
import static br.ce.wcaquino.matchers.MatchersProprios.ehHoje;
import static br.ce.wcaquino.matchers.MatchersProprios.ehHojeComDiferencaDias;
import static br.ce.wcaquino.utils.DataUtils.isMesmaData;
import static br.ce.wcaquino.utils.DataUtils.obterData;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.rules.ExpectedException;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.powermock.api.mockito.PowerMockito;

import br.ce.wcaquino.builders.UsuarioBuilder;
import br.ce.wcaquino.daos.LocacaoDao;
import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.exceptions.FilmeSemEstoqueException;
import br.ce.wcaquino.exceptions.LocadoraException;
import br.ce.wcaquino.utils.DataUtils;

public class LocacaoServiceTest {

	@Rule
	public ErrorCollector error = new ErrorCollector();

	@SuppressWarnings("deprecation")
	@Rule
	public ExpectedException exception = ExpectedException.none();

	@InjectMocks @Spy
	private LocacaoService service;

	@Mock
	private SPCService spcService;

	@Mock
	private EmailService emailService;

	@Mock
	private LocacaoDao locacaoDao;

	private Usuario usuario;

//	private int count = 0;

	@Before
	public void setup() {
//		System.out.println("Before");
		usuario = UsuarioBuilder.umUsuario().agora();

		MockitoAnnotations.initMocks(this);
//		service = PowerMockito.spy(service);

//		count++;
//		System.out.println("Valor contator: " + count);
	}

	@After
	public void tearDown() {
//		System.out.println("After");
	}

	@BeforeClass
	public static void setupClass() {
//		System.out.println("Before Class");
	}

	@AfterClass
	public static void tearDownClass() {
//		System.out.println("After Class");
	}

	@Test
	public void deveAlugarFilme() throws Exception {
		// Assume.assumeFalse(DataUtils.verificarDiaSemana(new Date(), Calendar.SATURDAY));

		// cenario
		List<Filme> filmes = Arrays.asList(umFilme().comValor(2.5).agora());
		Mockito.doReturn(DataUtils.obterData(15, 1, 2020)).when(service).obterData();

		// acao
		Locacao locacao;
		locacao = service.alugarFilme(usuario, filmes);

		// verificacao
		error.checkThat(locacao.getValor(), is(equalTo(2.5)));
		error.checkThat(isMesmaData(locacao.getDataLocacao(), obterData(15, 1, 2020)), is(true));
		error.checkThat(isMesmaData(locacao.getDataRetorno(), obterData(16, 1, 2020)), is(true));
	}

	

	@Test(expected = FilmeSemEstoqueException.class)
	public void deveRetornarUmExcecaoDeFilmeException() throws Exception {
		// cenario
		List<Filme> filmes = Arrays.asList(umFilme().semEstoque().agora());

		// acao
		Locacao locacao;
		locacao = service.alugarFilme(usuario, filmes);
	}

	@Test
	public void deveRetornarUmaMensagemDeUsuarioVazio() throws Exception {
		// cenario
		List<Filme> filmes = Arrays.asList(umFilme().agora());

		// acao
		try {
			service.alugarFilme(null, filmes);
		} catch (LocadoraException e) {
			assertThat(e.getMessage(), is("Usuario vazio"));
		}
	}

	@Test
	public void deveRetornarUmaExcecaoDeFilmeVazio() throws Exception {
		// acao
		exception.expect(LocadoraException.class);
		exception.expectMessage("Filme vazio");
		service.alugarFilme(usuario, null);
	}

	@Test
	public void naoDeveDevolverNaSegundaAoAlugarNoSabado() throws Exception {
		// Assume.assumeTrue(DataUtils.verificarDiaSemana(new Date(),
		// Calendar.SATURDAY));

		// cenario
		List<Filme> filmes = Arrays.asList(umFilme().agora());

		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, 16);
		calendar.set(Calendar.MONTH, 1);
		calendar.set(Calendar.YEAR, 2020);
		PowerMockito.mockStatic(Calendar.class);
		PowerMockito.when(Calendar.getInstance()).thenReturn(calendar);

		// acao
		Locacao locacao = service.alugarFilme(usuario, filmes);

		// verificacao
		assertThat(locacao.getDataRetorno(), caiNumaSegunda());
		PowerMockito.verifyStatic(times(2));
		Calendar.getInstance();
	}

	@Test
	public void naoDeveAlugarFilmeParaNegativadoSPC() throws Exception {
		// cenario
		List<Filme> filmes = Arrays.asList(umFilme().agora());
		exception.expect(LocadoraException.class);
		exception.expectMessage("Usuário Negativado");

		when(spcService.possuiNegativacao(Mockito.any(Usuario.class))).thenReturn(true);

		// acao
		service.alugarFilme(usuario, filmes);

		// verificacao
		Mockito.verify(spcService).possuiNegativacao(usuario);

	}

	@Test
	public void deveEnviarEmailParaLocacoesAtrasadas() {
		// cenario
		Usuario usuario = umUsuario().comNome("Leticia").agora();
		Usuario usuario2 = umUsuario().comNome("Bruno").agora();
		Usuario usuario3 = umUsuario().comNome("Matheus").agora();

		List<Locacao> locacoes = Arrays.asList(umLocacao().atrasado().comUsuario(usuario).agora(),
				umLocacao().comUsuario(usuario2).agora(), umLocacao().atrasado().comUsuario(usuario3).agora(),
				umLocacao().atrasado().comUsuario(usuario3).agora());

		Mockito.when(locacaoDao.obterLocacoesPendentes()).thenReturn(locacoes);

		// acao
		service.notificarAvisos();

		// verificacao
		verify(emailService, times(3)).notificarAtraso(Mockito.any(Usuario.class));
		verify(emailService).notificarAtraso(usuario);
		verify(emailService, atLeastOnce()).notificarAtraso(usuario3);
		verify(emailService, never()).notificarAtraso(usuario2);
		verifyNoMoreInteractions(emailService);
	}

	@Test
	public void deveTratarErroNoSPC() throws Exception {
		// cenario
		Usuario usuario = umUsuario().agora();
		List<Filme> filmes = Arrays.asList(umFilme().agora());

		when(spcService.possuiNegativacao(usuario)).thenThrow(new Exception("Falha catastrofica"));

		// verificacao
		exception.expect(LocadoraException.class);
		exception.expectMessage("SPC fora do ar, tente novamente");

		// acao
		service.alugarFilme(usuario, filmes);
	}

	@Test
	public void deveProrrogarUmaLocacao() {
		// cenario
		Locacao locacao = umLocacao().agora();

		// acao
		service.prorrogarLocacao(locacao, 7);

		// verificacao
		ArgumentCaptor<Locacao> argCapt = ArgumentCaptor.forClass(Locacao.class);
		Mockito.verify(locacaoDao).salvar(argCapt.capture());
		Locacao novaLocacao = argCapt.getValue();

		error.checkThat(novaLocacao.getValor(), is(8.0));
		error.checkThat(novaLocacao.getDataLocacao(), ehHoje());
		error.checkThat(novaLocacao.getDataRetorno(), ehHojeComDiferencaDias(7));
	}
	
	

	@Test
	public void deveCalcularValorLocacao() throws Exception {
		// cenario
		List<Filme> filmes = Arrays.asList(umFilme().agora());

		// acao
		Class<LocacaoService> clazz = LocacaoService.class;
		Method method = clazz.getDeclaredMethod("calcularValorLocacao", List.class);
		method.setAccessible(true);
		Double valorAtual = (Double) method.invoke(service, filmes);

		// verificacao
		Assert.assertThat(valorAtual, is(4.0));
	}
	
}
