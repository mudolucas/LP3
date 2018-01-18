create table curso(
	id int, 
	primary key(id), 
	nome varchar, 
	duracao int --tempo em horas
);

insert into curso values(1, 'Técnica vocal', 40);
insert into curso values(2, 'Apresentações de grande porte', 50);
insert into curso values(3, 'Apresentações de pequeno porte', 35);

create table locais(
	id int, 
	primary key(id), 
	nome varchar, 
	numeropessoas int, 
	tamanho int
);

insert into locais values(1, 'Shopping X', 400, 300);
insert into locais values(2, 'Casa do Abílio', 400, 300);
insert into locais values(3, 'Estádio Y', 6000, 900);

create table banda(
	id int, 
	primary key(id), 
	nome varchar, 
	genero varchar, 
	telefone int
);

insert into banda values(1, 'Bonde da Informática', 'Pop', 32321122);
insert into banda values(2, 'Banda dos caras', 'Rock', 32321123);
insert into banda values(3, 'Banda da 123', 'Rock', 32321133);
insert into banda values(4, 'Alberto', 'Pop Rock', 32321133);

create table artista(
	id int, 
	primary key(id), 
	nome varchar, 
	especialidade varchar, 
	nomeartistico varchar, 
	anonascimento int,
	idbanda int references banda(id)
);

insert into artista values(1, 'Ivana', 'Baterista', 'Iva', 1980, 1);
insert into artista values(2, 'Alberto', 'Vocalista', 'Beto', 1975, 1);
insert into artista values(3, 'Elizabeth', 'Vocalista', 'Beth', 1980, 2);
insert into artista values(4, 'Cláudia', 'Guitarrista', 'Cacau', 1987, 2);
insert into artista values(5, 'Cláudia Rios', 'Guitarrista', 'Cau', 1987, 2);

create table cursoartista(
	id int, 
	primary key(id), 
	idcurso int references curso(id), 
	idartista int references artista(id)	
);

insert into cursoartista values(1, 1, 2);
insert into cursoartista values(2, 1, 3);
insert into cursoartista values(3, 2, 1);
insert into cursoartista values(4, 2, 4);

create table shows(
	id int, 
	primary key(id), 
	nome varchar, 
	dia date, 
	horario varchar(5), 
	idlocais int references locais(id)
);
insert into shows values(1, 'Show de verão', '2017-01-29', '22:35', 2);
insert into shows values(2, 'Show da virada', '2017-01-31', '22:00', 1);

	

create table bandashow(
	id int, 
	primary key(id),
	idbanda int references banda(id), 
	idshow int references shows(id)
);

insert into bandashow values(1, 1, 1);
insert into bandashow values(2, 2, 2);


select count(*) from bandashow bs, banda b, shows s where bs.idbanda = b.id and b.nome = 'Bonde da Informática' and s.id = bs.idshow;
select count(*) from banda b, artista a where a.idbanda = b.id and b.nome = 'Bonde da Informática'

select b.nome from banda b, artista a, cursoartista ca, curso c where c.id = ca.idcurso and a.id=ca.idartista and b.id = a.idbanda and c.nome='Técnica vocal'

