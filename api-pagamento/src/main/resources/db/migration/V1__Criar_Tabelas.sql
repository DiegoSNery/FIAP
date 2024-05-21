CREATE TABLE pedido (
    pedido_id SERIAL PRIMARY KEY,
    tiket INTEGER NOT NULL,
    cliente_id INTEGER NOT NULL,
    cliente_id INTEGER NOT NULL,
    data_pedido TIMESTAMP NOT NULL,
);


CREATE TYPE status_pagamento_enum AS ENUM ('APROVADO', 'NAO_APROVADO', 'EM_ESPERA');

CREATE TABLE pagamento (
    pagamento_id SERIAL PRIMARY KEY,
    pedido_id INTEGER NOT NULL,
    valor DECIMAL(10, 2) NOT NULL,
    data_pagamento TIMESTAMP NOT NULL,
    status_pagamento status_pagamento_enum NOT NULL,
    FOREIGN KEY (pedido_id) REFERENCES Pedido(pedido_id)
);

CREATE TABLE processador_pagamento (
    processador_id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    tipo VARCHAR(50) NOT NULL
);

CREATE TABLE transacao_pagamento (
    transacao_id SERIAL PRIMARY KEY,
    pagamento_id INTEGER NOT NULL,
    processador_id INTEGER NOT NULL,
    data_transacao TIMESTAMP NOT NULL,
    resposta_processador TEXT NOT NULL,
    FOREIGN KEY (pagamento_id) REFERENCES Pagamento(pagamento_id),
    FOREIGN KEY (processador_id) REFERENCES ProcessadorPagamento(processador_id)
);
