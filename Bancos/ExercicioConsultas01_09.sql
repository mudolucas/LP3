create table grupodeciclistas(
	id int, 
	primary key(id), 
	nome varchar
);

insert into grupodeciclistas values(1, 'Feras do pedal');
insert into grupodeciclistas values(2, 'Grupo dos caras');
insert into grupodeciclistas values(3, 'Grupo dos feras'); 

create table ciclista(
	id int, 
	primary key(id), 
	nome varchar, 
	cpf varchar,
	idgrupo int references grupodeciclistas(id)
);

insert into ciclista values(1, 'Pedro Rocha', '123', 1);
insert into ciclista values(2, 'Pedro Ricardo', '123', 1);
insert into ciclista values(3, 'Pedro Ribeiro', '123', 2);

create table bicicleta(
	id int, 
	primary key(id), 
	modelo varchar, 
	valor float
);

insert into bicicleta values(1, 'Pivot Vault Ciclocross', 10.000);
insert into bicicleta values(2, 'Mtb Scott Scale 900 Premium', 38.000);
insert into bicicleta values(3, 'Bmc Tean Elite 02 Slx/xt Aro 29', 12.000);
insert into bicicleta values(4, 'Pivot Vault Ciclocross', 20.000);

create table acessorio(
	id int, 
	primary key(id), 
	nome varchar, 
	valor float, 
	caracteristica varchar
);

insert into acessorio values(1, 'Lanterna frontal', 30.00, 'Resistente a água');
insert into acessorio values(2, 'Sapatilha', 200.000, 'Produto leve e confortável');
insert into acessorio values(3, 'Luva com gel', 240.00, 'Possui a palma revestida com uam fina camada de gel');

create table treino(
	id int, 
	primary key(id), 
	roteiro varchar
);

insert into treino values(1, 'Treino noturno na avenida X');
insert into treino values(2, 'Treino em trilhas');
insert into treino values(3, 'Treino diário');

create table treinociclista(
	id int, 
	primary key(id), 
	idtreino int references treino(id), 
	idciclista int references ciclista(id)
);

insert into treinociclista values(1, 1, 1);
insert into treinociclista values(2, 3, 2);
insert into treinociclista values(3, 2, 1);


create table bicicletaciclista(
	id int, 
	primary key(id), 
	idbicicleta int references bicicleta(id), 
	idciclista int references ciclista(id)
);

insert into bicicletaciclista values(1, 1, 1);
insert into bicicletaciclista values(2, 2, 1);
insert into bicicletaciclista values(3, 2, 2);
insert into bicicletaciclista values(4, 3, 3);


create table bicicletaacessorio(
	id int, 
	primary key(id), 
	idbicicleta int references bicicleta(id), 
	idacessorio int references acessorio(id)
);

insert into bicicletaacessorio values(1, 2, 2);
insert into bicicletaacessorio values(2, 2, 3);
insert into bicicletaacessorio values(3, 1, 1);
insert into bicicletaacessorio values(4, 3, 3);


select c.nome, b.modelo from ciclista c, bicicleta b, bicicletaciclista bc where c.id = bc.idciclista and b.id = bc.idbicicleta

select b.modelo, a.nome from bicicleta b, acessorio a, bicicletaacessorio ba where b.id=ba.idbicicleta and a.id=ba.idacessorio

select b.modelo from bicicleta b where b.valor > 0.500
--1
select c.nome as ciclista, modelo, a.nome as acessorio from ciclista c, acessorio a, bicicleta b,  bicicletaacessorio ba, bicicletaciclista bc where c.id = bc.idciclista and b.id = bc.idbicicleta
and b.id = ba.idbicicleta and a.id = ba.idacessorio;
--2
select c.nome from ciclista c, bicicleta b, acessorio a, bicicletaacessorio ba, bicicletaciclista bc where c.id = bc.idciclista and b.id = bc.idbicicleta
and b.id = ba.idbicicleta and a.id = ba.idacessorio and b.valor > 0.500 and a.nome = 'Luva com gel'
--3
select c.nome, t.roteiro from ciclista c, treino t, bicicleta b, bicicletaciclista bc, treinociclista tc where c.id = bc.idciclista and b.id = bc.idbicicleta and
c.id = tc.idciclista and t.id = tc.idtreino and b.modelo = 'Pivot Vault Ciclocross'; 
--4
select b.modelo from bicicleta b, bicicletaacessorio ba, acessorio a where b.id=ba.idbicicleta and a.id=ba.idacessorio and b.valor>1.000 and a.nome = 'Sapatilha'
--5
select c.nome, b.modelo from ciclista c, bicicleta b, bicicletaciclista bc, treino t, treinociclista tc, grupodeciclistas gc where c.id = bc.idciclista and b.id = bc.idbicicleta and
c.id = tc.idciclista and t.id = tc.idtreino and c.idgrupo = gc.id and t.roteiro = 'Treino noturno na avenida X' and gc.nome='Feras do pedal' and b.valor>15.000