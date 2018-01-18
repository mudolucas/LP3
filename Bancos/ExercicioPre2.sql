create table pais(
	id int, 
	primary key(id), 
	nome varchar
);

insert into pais values(1, 'Brasil');

create table loja(
	id int, 
	primary key(id), 
	status varchar, 
	endereco varchar
);


insert into loja values(1, 'Matriz', 'Rua x');
insert into loja values(2, 'Filial', 'Rua Y');
insert into loja values(3, 'Filial', 'Rua Z');

create table funcionario(
	id int, 
	primary key(id), 
	nome varchar, 
	sexo varchar, 
	idade int, 
	idloja int references loja(id)
);

insert into funcionario values(1, 'Anderson Batista', 'Masculino', 29, 1);
insert into funcionario values(2, 'Luana Rosa', 'Feminino', 22, 2);
insert into funcionario values(3, 'Luanderson Batista', 'Masculino', 21, 2);
insert into funcionario values(4, 'Ana Rosa', 'Feminino', 19, 3);
insert into funcionario values(5, 'Cleanderson Batista', 'Masculino', 32, 3);

create table fornecedor(
	id int, 
	primary key(id), 
	nome varchar, 
	idpais int references pais(id)
);

insert into fornecedor values(1, 'Fornecedor X', 1);
insert into fornecedor values(2, 'Fornecedor Y', 1);
insert into fornecedor values(3, 'Fornecedor Z', 1);

create table produto(
	id int, 
	primary key(id), 
	idademinima int, 
	valor float, 
	nome varchar, 
	idfornecedor int references fornecedor(id)
);

insert into produto values(1, 2, 20.00, 'Estojo da Dra. Brinquedo', 1);
insert into produto values(2, 6, 60.00, 'Mochila da Barbie', 2);
insert into produto values(3, 4, 2.00, 'Caneta azul divino', 2);
insert into produto values(4, 3, 25.00, 'Caderno de 20 matérias', 3);
insert into produto values(5, 4, 3.00, 'Lápis da pequena sereia', 3);
insert into produto values(6, 3, 4.00, 'Borracha da Frozen', 3);

create table produtoloja(
	id int, 
	primary key(id), 
	idloja int references loja(id), 
	idproduto int references produto(id)
);


insert into produtoloja values(1, 1, 1); 
insert into produtoloja values(2, 1, 6); 

insert into produtoloja values(3, 2, 5); 
insert into produtoloja values(4, 2, 1); 
insert into produtoloja values(5, 2, 4); 

insert into produtoloja values(6, 3, 2); 
insert into produtoloja values(7, 3, 3); 

insert into produtoloja values(8, 2, 1); 

select count(produtoloja.id) from produtoloja, produto, fornecedor where idproduto in (select p.id from produto p where p.valor=60.00)
and idproduto = produto.id and produto.idfornecedor in (select f.id from fornecedor f where f.nome='Fornecedor Y') and produto.idfornecedor = fornecedor.id

select produtoloja.id from produtoloja, produto, fornecedor where idproduto=produto.id and idfornecedor=fornecedor.id

select * from produto