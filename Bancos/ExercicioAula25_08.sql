create table medico(
	id serial primary key, 
	nome varchar, 
	especialidade varchar
);
create table paciente(
	id serial primary key, 
	nomepaciente varchar, 
	idade int
);
create table consulta(
	id serial primary key, 
	idmedico int references medico(id), 
	idpaciente int references paciente(id)
);
