insert into empresas (nome, cnpj) 
values 
	('Bradesco', '65629115000195'),
	('Vale', '20606043000122'),
    ('Cielo', '86994944000147');
    
alter table empresas modify cnpj varchar(14);    

select * from empresas;

desc empresas;

insert into empresas_unidades (empresa_id, cidade_id, sede)
values
	(1, 1, 1),
    (1, 2, 0),
    (2, 1, 0),
    (2, 2, 1);
    

