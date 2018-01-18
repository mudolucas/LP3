create table fabricante(
	id serial, 
	primary key(id), 
	nome varchar
);

insert into fabricante(nome) values('Zaeli');
insert into fabricante(nome) values('Yoki');
insert into fabricante(nome) values('Dolly');

create table lote(
	id serial, 
	primary key(id), 
	numero int, 
	dataDeFabricacao date, 
	idfabricante int references fabricante(id)
);

insert into lote(dataDeFabricacao, idfabricante) values('2017-5-10', 1);
insert into lote(dataDeFabricacao, idfabricante) values('2017-6-10', 2);
insert into lote(dataDeFabricacao, idfabricante) values('2017-6-10', 3);
insert into lote(dataDeFabricacao, idfabricante) values('2017-9-10', 1);
select * from lote;
create table produto(
	id serial, 
	primary key(id), 
	nome varchar
);

insert into produto(nome) values('Refrigerante');
insert into produto(nome) values('Bolo');
insert into produto(nome) values('Torta');

create table venda(
	id serial, 
	primary key(id), 
	dia date, 
	hora time
);

insert into venda(dia, hora) values('2017-5-10', '10:10:00');
insert into venda(dia, hora) values('2017-5-10', '10:30:00');
insert into venda(dia, hora) values('2017-09-29', '10:30:00');

create table loteproduto(
	id serial, 
	primary key(id), 
	nome varchar, 
	idlote int references lote(id), 
	idproduto int references produto(id)
);

insert into loteproduto(nome, idlote, idproduto) values('Lote 1', 3, 1);
insert into loteproduto(nome, idlote, idproduto) values('Lote 2', 2, 2);
insert into loteproduto(nome, idlote, idproduto) values('Lote 3', 1, 3);
insert into loteproduto(nome, idlote, idproduto) values('Lote 4', 4, 2);

create table produtovenda(
	id serial, 
	primary key(id), 
	idproduto int references produto(id), 
	idvenda int references venda(id)
);

insert into produtovenda(idproduto, idvenda) values(1, 1);
insert into produtovenda(idproduto, idvenda) values(2, 1);
insert into produtovenda(idproduto, idvenda) values(3, 1);
insert into produtovenda(idproduto, idvenda) values(2, 2);
insert into produtovenda(idproduto, idvenda) values(3, 2);

'

 