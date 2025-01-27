INSERT INTO usuario (id, data_criacao, email, nome, senha) VALUES
(4, '2025-01-01 10:00:00', 'joao.silva@example.com', 'João Silva', 'senha123'),
(2, '2025-01-02 11:30:00', 'maria.oliveira@example.com', 'Maria Oliveira', 'maria123'),
(5, '2025-01-03 14:45:00', 'carlos.souza@example.com', 'Carlos Souza', 'carlos123'),
(6, '2025-01-04 09:15:00', 'ana.lima@example.com', 'Ana Lima', 'ana123'),
(7, '2025-01-05 16:20:00', 'fernando.alves@example.com', 'Fernando Alves', 'fernando123'),
(8, '2025-01-06 13:50:00', 'luisa.pereira@example.com', 'Luisa Pereira', 'luisa123'),
(9, '2025-01-07 08:30:00', 'rafael.martins@example.com', 'Rafael Martins', 'rafael123'),
(10, '2025-01-08 17:10:00', 'camila.santos@example.com', 'Camila Santos', 'camila123'),
(11, '2025-01-09 12:40:00', 'pedro.almeida@example.com', 'Pedro Almeida', 'pedro123'),
(12, '2025-01-10 10:25:00', 'juliana.monteiro@example.com', 'Juliana Monteiro', 'juliana123');

INSERT INTO tarefas (id, data_criacao, data_vencimento, descricao, status, titulo, ultima_atualizacao, usuario_id) VALUES
(1, '2025-01-01', '2025-01-05', 'Descrição da tarefa 1', 'PENDENTE', 'Título da tarefa 1', '2025-01-01', 1),
(2, '2025-01-02', '2025-01-06', 'Descrição da tarefa 2', 'EM_ANDAMENTO', 'Título da tarefa 2', '2025-01-03', 2),
(3, '2025-01-03', '2025-01-10', 'Descrição da tarefa 3', 'CONCLUIDA', 'Título da tarefa 3', '2025-01-09', 3),
(4, '2025-01-04', '2025-01-08', 'Descrição da tarefa 4', 'PENDENTE', 'Título da tarefa 4', '2025-01-04', 4),
(5, '2025-01-05', '2025-01-12', 'Descrição da tarefa 5', 'EM_ANDAMENTO', 'Título da tarefa 5', '2025-01-06', 5),
(6, '2025-01-06', '2025-01-13', 'Descrição da tarefa 6', 'PENDENTE', 'Título da tarefa 6', '2025-01-07', 1),
(7, '2025-01-07', '2025-01-15', 'Descrição da tarefa 7', 'CONCLUIDA', 'Título da tarefa 7', '2025-01-10', 2),
(8, '2025-01-08', '2025-01-18', 'Descrição da tarefa 8', 'PENDENTE', 'Título da tarefa 8', '2025-01-08', 3),
(9, '2025-01-09', '2025-01-20', 'Descrição da tarefa 9', 'EM_ANDAMENTO', 'Título da tarefa 9', '2025-01-11', 4),
(10, '2025-01-10', '2025-01-22', 'Descrição da tarefa 10', 'PENDENTE', 'Título da tarefa 10', '2025-01-12', 5),