# API Cadastro Mercado Livre

Este projeto Java realiza a integração com a [API do Mercado Livre](https://developers.mercadolivre.com.br/), permitindo autenticar usuários e cadastrar produtos de forma automatizada.

## 📌 Funcionalidades

- ✅ Autenticação via OAuth 2.0 com o Mercado Livre  
- ✅ Consumo da API de categorias e atributos do Mercado Livre  
- ✅ Cadastro automatizado de produtos no marketplace  
- ✅ Suporte à importação de dados em JSON e CSV  
- ✅ Associação de produtos ao usuário autenticado  

## 🛠️ Tecnologias Utilizadas

- Java 17+
- Jakarta EE 10
- JPA (EclipseLink ou Hibernate)
- Payara Server 6 / TomEE 9+
- Maven
- Jackson
- JAX-RS (API REST)

## 📁 Estrutura do Projeto

```
api-cadastro-mercado-livre/
├── src/
│   └── main/
│       ├── java/
│       │   └── com.mercadoturbo/
│       │       ├── api/           → Endpoints REST
│       │       ├── dto/           → DTOs para integração com a API externa
│       │       ├── model/         → Entidades JPA
│       │       └── service/       → Lógica de negócio
│       └── resources/
│           └── META-INF/
│               └── persistence.xml
├── pom.xml
└── README.md
```

## 🚀 Como Executar o Projeto

### Pré-requisitos

- JDK 17 ou superior
- Maven 3.8+
- Servidor compatível: Payara Server 6 ou TomEE 9+
- Banco de dados MySQL configurado e linkado com o Payara Server 6
- Conta de desenvolvedor no Mercado Livre

### Passo a passo

1. **Clone o repositório**

```bash
git clone https://github.com/Nicolas22prog/api-cadastro-mercado-livre.git
cd api-cadastro-mercado-livre
```

2. **Configure o banco de dados em `persistence.xml`**

3. **Compile o projeto com Maven**

```bash
mvn clean install
```
4. **Configure o banco de dados criando o schema chamado mercado_livre e crie duas tabelas com o seguinte comando:**
  ```
CREATE TABLE garantias (
    id INT AUTO_INCREMENT PRIMARY KEY,
    tipo VARCHAR(100) NOT NULL,           -- Ex: "fabricante", "loja"
    duracaoMeses INT NOT NULL,           -- Duração da garantia
    origem VARCHAR(100),                  -- De quem vem a garantia
    detalhes TEXT                         -- Detalhes adicionais
) ENGINE=InnoDB;


CREATE TABLE produtos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    seller_id INT NOT NULL,
    title VARCHAR(100) NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    category_id VARCHAR(100),
    available_quantity INT NOT NULL,
    garantia tinyint(1),
    permalink VARCHAR(500),
    thumbnail VARCHAR(500),
    shippingMode VARCHAR(500),
    logisticType VARCHAR(500),
    status VARCHAR(500),
    date_created VARCHAR(500),
    garantia_id INT,  -- pode ser NULL
    FOREIGN KEY (garantia_id) REFERENCES garantias(id)
        ON DELETE SET NULL
        ON UPDATE CASCADE
) ENGINE=InnoDB;
```
5. **Autenticação do mercado livre**
   -Usuario que for testar devera ter um token de vendedor do mercado livre para que funcione
    
7. **Implante o arquivo `.war` gerado no servidor de aplicação**

8. **Acesse os endpoints da API:**

- `GET /api/produtos` — Lista os produtos cadastrados  
- `GET /api/produtos/importar` — Cadastra produtos via JSON 


## 📄 Licença

Este projeto está licenciado sob a licença MIT.

---

Desenvolvido por [@Nicolas22prog](https://github.com/Nicolas22prog) 🚀
