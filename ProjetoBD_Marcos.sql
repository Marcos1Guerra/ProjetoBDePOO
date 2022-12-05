CREATE DATABASE P_Hospital;
Use P_Hospital;

CREATE TABLE Hospital(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Nome VARCHAR(45),
    Endereco VARCHAR(45)
	);

CREATE TABLE Medico(
	CRM INT NOT NULL PRIMARY KEY,
	Nome VARCHAR(45),
    Funcao VARCHAR(45)
);

CREATE TABLE Paciente (
    CPF INT NOT NULL PRIMARY KEY,
    Nome VARCHAR(40),
    Idade INT
);


CREATE TABLE Quarto(
	Numero INT NOT NULL PRIMARY KEY,
    Prioridade VARCHAR(40)
);

SELECT * FROM Hospital;
SELECT * FROM Medico;
SELECT * FROM Quarto;
SELECT * FROM Paciente;






