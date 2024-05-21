CREATE TABLE cliente (
    cliente_id SERIAL PRIMARY KEY,
    nome VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    cpf VARCHAR(11) UNIQUE,
    telefone VARCHAR(20)
);


CREATE TABLE categoria (
    categoria_id SERIAL PRIMARY KEY,
    nome VARCHAR(50) NOT NULL UNIQUE
);

-- Inserindo categorias fixas
INSERT INTO categoria (nome) VALUES
('Lanche'),
('Acompanhamento'),
('Bebida'),
('Sobremesa');


CREATE TABLE produto (
    produto_id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao TEXT,
    preco DECIMAL(10, 2) NOT NULL,
    imagem VARCHAR(255),
    categoria_id INTEGER NOT NULL,
    FOREIGN KEY (categoria_id) REFERENCES Categoria(categoria_id)
);

CREATE TABLE pedido (
    pedido_id SERIAL PRIMARY KEY,
    tiket INTEGER NOT NULL,
    cliente_id INTEGER,
    data_pedido TIMESTAMP NOT NULL,
    status VARCHAR(50) NOT NULL,
    total DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (cliente_id) REFERENCES Cliente(cliente_id)
);

CREATE TABLE pedido_item (
    pedido_item_id SERIAL PRIMARY KEY,
    pedido_id INTEGER NOT NULL,
    produto_id INTEGER NOT NULL,
    quantidade INTEGER NOT NULL,
    preco DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (pedido_id) REFERENCES Pedido(pedido_id) ON DELETE CASCADE,
    FOREIGN KEY (produto_id) REFERENCES Produto(produto_id)
);