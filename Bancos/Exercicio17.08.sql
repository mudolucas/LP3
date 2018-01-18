create table aluno(
	id serial,
	primary key (id),
	nome varchar,
	idCategoria int,
	foreign key (idCategoria) references categoria(id),
	peso float,
	altura float
)

create table categoria(
	id serial,
	primary key (id),
	categoria varchar
)

select * from categoria
select * from aluno

insert into categoria(categoria) values ('Volei');
insert into aluno(nome,idCategoria,peso,altura) values ('Teste', 1, 50.0, 1.7);