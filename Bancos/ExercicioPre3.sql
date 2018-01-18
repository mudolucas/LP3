create table curso(
	id int, 
	primary key(id), 
	nome varchar, 
	duracao int
);

insert into curso values(1, 'Engeharia Civil', 8);
insert into curso values(2, 'Engeharia Mecatrônica', 8);
insert into curso values(3, 'Engeharia de Computação', 10);

create table universidade(
	id int, 
	primary key(id), 
	nome varchar
);

insert into universidade values(1, 'UCDB');
insert into universidade values(2, 'UNIDERP');

create table professor(
	id int, 
	primary key(id), 
	nome varchar, 
	areadeatuacao varchar, 
	titulacao varchar, 
	iduniversidade int references universidade(id)
);

insert into professor values(1, 'João', 'Programação de computadores', 'Doutor', 1);
insert into professor values(2, 'Rui', 'Matemática', 'Mestre', 1);

insert into professor values(3, 'Beto', 'Ética', 'Mestre', 2);
insert into professor values(4, 'Roni', 'Física', 'Doutor', 2);

create table disciplina(
	id int, 
	primary key(id), 
	nome varchar, 
	cargahoraria int, 
	ementa varchar, 
	idprofessor int references professor(id)
);

insert into disciplina values(1, 'Programação', 60, 'Programação básica', 1);
insert into disciplina values(2, 'Física', 80, 'Física básica', 4);
insert into disciplina values(3, 'Ética', 20, 'Ética em computação', 3);
insert into disciplina values(4, 'Português', 60, 'Português Básico', 1);
insert into disciplina values(5, 'Matemática', 80, 'Matemática básica', 2);

create table aluno(
	id int, 
	primary key(id), 
	nome varchar, 
	idade int, 
	sexo varchar, 
	idcurso int references curso(id)
);

insert into aluno values(1, 'Isac', 18, 'Masculino', 1);
insert into aluno values(2, 'João', 18, 'Masculino', 2);
insert into aluno values(3, 'Ana', 18, 'Feminino', 3);
insert into aluno values(4, 'Lua', 19, 'Feminino', 3);

create table disciplinacurso(
	id int, 
	primary key(id), 
	iddisciplina int references disciplina(id), 
	idcurso int references curso(id)
);

insert into disciplinacurso values(1, 1, 3);
insert into disciplinacurso values(2, 4, 3);
insert into disciplinacurso values(3, 3, 3);
insert into disciplinacurso values(4, 2, 1);
insert into disciplinacurso values(5, 5, 2);

