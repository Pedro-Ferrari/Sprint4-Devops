-- Criação da tabela USUARIOS
CREATE TABLE USUARIOS (
    ID NUMBER(19) PRIMARY KEY,           
    EMAIL VARCHAR2(255) NOT NULL,        
    NOME VARCHAR2(255) NOT NULL,          
    SENHA VARCHAR2(255) NOT NULL,        
    CARGO_ID NUMBER(19),                
    CONSTRAINT USUARIOS_PK PRIMARY KEY (ID)
);

-- Comentários da tabela USUARIOS
COMMENT ON COLUMN USUARIOS.ID IS 'Identificador único do usuário';
COMMENT ON COLUMN USUARIOS.EMAIL IS 'Email único do usuário';
COMMENT ON COLUMN USUARIOS.NOME IS 'Nome completo do usuário';
COMMENT ON COLUMN USUARIOS.SENHA IS 'Senha do usuário';
COMMENT ON COLUMN USUARIOS.CARGO_ID IS 'Referência ao cargo do usuário';

-- Criação da tabela FEEDBACKS
CREATE TABLE FEEDBACKS (
    ID NUMBER(19) PRIMARY KEY,           
    DATA TIMESTAMP NOT NULL,             
    DESCRICAO VARCHAR2(255) NOT NULL,  
    NOTA NUMBER(10) NOT NULL,
    USUARIO_ID NUMBER(19) NOT NULL,
    CONSTRAINT FEEDBACKS_PK PRIMARY KEY (ID),
    CONSTRAINT FK_USUARIO_FEEDBACK FOREIGN KEY (USUARIO_ID)
        REFERENCES USUARIOS(ID)        

-- Comentários da tabela FEEDBACKS
COMMENT ON COLUMN FEEDBACKS.ID IS 'Identificador único do feedback';
COMMENT ON COLUMN FEEDBACKS.DATA IS 'Data e hora em que o feedback foi registrado';
COMMENT ON COLUMN FEEDBACKS.DESCRICAO IS 'Descrição detalhada do feedback';
COMMENT ON COLUMN FEEDBACKS.NOTA IS 'Nota atribuída pelo cliente no feedback';
COMMENT ON COLUMN FEEDBACKS.USUARIO_ID IS 'Referência ao usuário que recebeu o feedback';
