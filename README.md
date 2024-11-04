# Projeto Analyzer - Descrição da Aplicação

Este repositório contém a aplicação `Analyzer`, desenvolvida em Java Spring Boot
## Pré-requisitos

Antes de executar a aplicação, certifique-se de que você possui os seguintes itens:

- **Java 17** ou superior
- **Maven** (versão 3.6 ou superior)
- **Azure DevOps** (para executar a pipeline)
- **Git**

## Estrutura do Projeto

- **src/**: Código fonte da aplicação
- **pom.xml**: Arquivo de configuração do Maven
- **target/**: Pasta onde o arquivo `.jar` gerado pelo Maven será armazenado após a compilação
- **script.sql**: Script de banco de dados para configurar as tabelas

## Configuração da Pipeline no Azure DevOps

### Passo a Passo para Executar a Pipeline

1. **Clone o repositório**:
   ```bash
   git clone https://github.com/Pedro-Ferrari/Sprint4-Devops
Configuração do Azure DevOps: No Azure DevOps, crie uma nova pipeline para este repositório.

Configuração de Variáveis no Azure DevOps: Defina as seguintes variáveis na pipeline (se aplicável):

AZURE_SUBSCRIPTION: Insira a assinatura do Azure
RESOURCE_GROUP: Nome do grupo de recursos
APP_SERVICE_NAME: Nome do Serviço de Aplicativo
APP_PLAN_NAME: Nome do Plano de Serviço
Execução da Pipeline: Após configurar as variáveis e a pipeline, execute-a manualmente. 
Ela seguirá as etapas para compilar, testar e fazer o deploy da aplicação.

A aplicação estará disponível no link disponibilizado pelo serviço de aplicativo.
