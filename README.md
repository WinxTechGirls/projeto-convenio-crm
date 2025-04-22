## <h1> DESAFIO 1 BACKEND: Criando um projeto Spring com múltiplas entidades e CRUD COMPLETO </h1> 


 ### 🏗👨‍💻 Equipe 

Lays Sabryna - https://github.com/SabrynaSousa

Najla Guimarães - https://github.com/NahGuimaraes

Nycolly Weiss - https://github.com/NycollyWeiss

Thais Machado - https://github.com/machadothais

Mireli Borges - https://github.com/mikaborges

Mariana Marie - https://github.com/ihamari

Isabella Bento - https://github.com/



### <h2>📢 Título do Projeto </h2>

Sistema de Gestão de Relacionamento com o Cliente (CRM)



### 🏢 Modelo de Negócio Escolhido 

O projeto tem como objetivo desenvolver um Sistema CRM para gerenciamento de usuários, convênios e tipos. A aplicação permitirá o cadastro, atualização, consulta e remoção de dados, garantindo uma gestão eficiente e organizada.



### 📖 Descrição Geral 

O ConvênioLorenzo é uma plataforma online que visa a gestão de convênios de saúde. O sistema permite que os usuários se cadastrem, escolham o convênio de acordo com as suas necessidades e vejam os benefícios oferecidos por cada plano. O sistema também disponibiliza a organização dos convênios em três tipos (Básico, Intermediário e Plus), com características distintas, como preço, acomodação e cobertura.


### 📂 Entidade e Atributos da Entidade 

A aplicação contará com três entidades principais:

1. Usuário

Listar Todos Usuários

Procurar por ID

Cadastrar Usuário

Atualizar Usuário 

Deletar Usuário


2. Convênio

Listar Todos os Convênios

Procurar por ID

Procurar por Nome

Procurar por Preço Máximo

Cadastrar Convênio

Atualizar Convênio

Deletar Convênio


3. Tipo

Listar Todos os Tipos

Procurar por ID

Procurar por Nome

Cadastrar Tipo

Atualizar Tipo

Deletar Tipo


Relacionamentos:

Um Convênio pertence a uma Tipo (Muitos para Um)

Um Tipo pertence a um Usuário (Muitos para Um)



### ⚙️ Funcionalidades Principais (CRUD) 

O sistema oferecerá as seguintes operações para cada entidade:

Usuário

Criar um novo usuário

Listar todos os usuários

Buscar usuário por ID

Atualizar informações do usuário

Excluir um usuário

Categoria

Criar uma nova categoria

Listar todas as categorias

Buscar categoria por ID

Atualizar informações da categoria

Excluir uma categoria

Produto

Criar um novo produto

Listar todos os produtos

Buscar produto por ID

Atualizar informações do produto

Excluir um produto

Buscar produtos por nome



### 🛠️ Tecnologias Utilizadas 

Java

Spring Boot Dev Tools

Spring Web

Maven

Spring Data JPA

Insomnia

Validation

MySQL Driver

MySQL Workbench



### 📁 Estrutura do Projeto 

O projeto será organizado seguindo as boas práticas de desenvolvimento, com a seguinte estrutura:

/src

├── main

│ ├── java/com/Projeto-CRM/crm

│ │ ├── controller # Controladores da API

│ │ ├── service # Regras de negócio

│ │ ├── repository # Repositórios para acesso ao banco

│ │ ├── model # Modelos das entidades

│ │ ├── dto # Objetos de transferência de dados

│ │ ├── config # Configurações gerais

│ ├── resources

│ │ ├── application.properties # Configurações do Spring Boot
