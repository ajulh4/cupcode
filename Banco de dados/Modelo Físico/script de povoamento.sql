use cupcode_db;

/* POVOAMENTO DAS DIFICULDADES DAS QUESTÕES */
insert into dificuldade_questao(nivel) values ('Fácil'), ('Médio'), ('Difícil');

/* POVOAMENTO DOS MODOS DE QUESTÕES */
insert into modo_questao(modo) values ('Verdadeiro ou Falso'), ('Múltipla escolha'), ('Bloco de código');


/* POVOAMENTO DAS CONQUISTAS */
insert into conquista(nome, descricao, icon) values
('Hello World', 'Ganha ao iniciar o curso Java', 1),
('Primeiros Passos','Ganha ao concluir o primeiro quiz e pontuar para o ranking', 2),
('Alvo na Mira', 'Ganha ao terminar 3 quizzes sem errar nenhuma questão', 3),
('Rumo ao Topo', 'Ganha ao conquistar maior pontuação possivel em umaquiz (212)', 4),
('Pequeno gafanhoto', 'Ganha ao concluir o módulo de PEOO ', 5),
('Codificando', 'Ganha ao concluir o módulo de PE', 6),
('Programador', 'Ganha ao concluir o módulo de POO', 7),
('Flash', 'Complete 3 quizzes em até 3 minutos', 8),
('Deus do Java', 'Alcance o primeiro lugar no ranking', 9),
('Determinação que chama', 'Obtenha a pontuação necessária para continuar o curso após refazer o quiz', 10);

/* POVOAMENTO DOS ASSUNTOS */
insert into assunto(titulo) values
('Conceitos Fundamentais'), ('Tipos de Dados'), ('Memória, Constantes e Variáveis'),
('Tipos de Operadores'), ('Comandos de Entrada e Saída'), ('Estruturas Condicionais'),
('Estruturas de Repetição'), ('Vetores'), ('Matrizes'), ('Funções'),('Manipulação de String'),
('Classes e Objetos'), ('Atributos e Métodos'), ('Abstração e Encapsulamento'), ('Construtores'),
('Relacionamento entre Objetos'), ('Herança'), ('Classes Abstratas'), ('Métodos Abstratos'),
('Interfaces'), ('Polimorfismo'), ('Tratamento de Exceções'), ('Coleções de Objetos'), ('Serialização e Persistência de Objetos');


