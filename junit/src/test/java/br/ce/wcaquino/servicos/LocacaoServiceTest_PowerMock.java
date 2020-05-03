package br.ce.wcaquino.servicos;

import static br.ce.wcaquino.builders.FilmeBuilder.umFilme;
import static br.ce.wcaquino.builders.UsuarioBuilder.umUsuario;
import static br.ce.wcaquino.matchers.MatchersProprios.caiNumaSegunda;
import static br.ce.wcaquino.utils.DataUtils.isMesmaData;
import static br.ce.wcaquino.utils.DataUtils.obterData;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;

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
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import br.ce.wcaquino.builders.UsuarioBuilder;
import br.ce.wcaquino.daos.LocacaoDao;
import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;

@RunWith(PowerMockRunner.class)
@PrepareForTest(LocacaoService.class)
public class LocacaoServiceTest_PowerMock {

	@Rule
	public ErrorCollector error = new ErrorCollector();

	@SuppressWarnings("deprecation")
	@Rule
	public ExpectedException exception = ExpectedException.none();

	@InjectMocks
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
		service = PowerMockito.spy(service);

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
		// Assume.assumeFalse(DataUtils.verificarDiaSemana(new Date(),
		// Calendar.SATURDAY));

		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, 15);
		calendar.set(Calendar.MONTH, 0);
		calendar.set(Calendar.YEAR, 2020);
		PowerMockito.mockStatic(Calendar.class);
		PowerMockito.when(Calendar.getInstance()).thenReturn(calendar);

		// cenario
		List<Filme> filmes = Arrays.asList(umFilme().comValor(2.5).agora());

		// acao
		Locacao locacao;
		locacao = service.alugarFilme(usuario, filmes);

		// verificacao
		error.checkThat(locacao.getValor(), is(equalTo(2.5)));
		error.checkThat(isMesmaData(locacao.getDataLocacao(), obterData(15, 1, 2020)), is(true));
		error.checkThat(isMesmaData(locacao.getDataRetorno(), obterData(16, 1, 2020)), is(true));
	}

	@Test
	public void deveAlugarFilmeSemCalcularValor() throws Exception {
		// cenario
		Usuario usuario = umUsuario().agora();
		List<Filme> filmes = Arrays.asList(umFilme().agora());
		PowerMockito.doReturn(1.0).when(service, "calcularValorLocacao", filmes);

		// acao
		Locacao locacao = service.alugarFilme(usuario, filmes);

		// verificacao
		assertThat(locacao.getValor(), is(1.0));
		PowerMockito.verifyPrivate(service).invoke("calcularValorLocacao", filmes);
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
	public void deveCalcularValorLocacao() throws Exception {
		// cenario
		List<Filme> filmes = Arrays.asList(umFilme().agora());

		// acao
		Double valorAtual = (Double) Whitebox.invokeMethod(service, "calcularValorLocacao", filmes);

		// verificacao
		Assert.assertThat(valorAtual, is(4.0));

	}

}
