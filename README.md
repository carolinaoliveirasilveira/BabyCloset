# 👶 BabyCloset

O **BabyCloset** é um sistema completo para auxiliar na organização de roupas e itens de enxoval de bebês. Ele permite cadastrar, visualizar, trocar e acompanhar os itens disponíveis no guarda-roupa, promovendo reuso, doações e controle personalizado por faixa etária e categoria.

---

## ⚙️ Tecnologias utilizadas

- Java 17 + Spring Boot 3
- Kafka + Redpanda
- PostgreSQL
- Docker + Docker Compose
- Microsserviços (padrão **Saga Orquestrado**)
- Gradle
- Insomnia para testes de API
- Swagger (SpringDoc) para documentação de endpoints

---

## 🧱 Arquitetura de Microsserviços

O sistema é dividido em três serviços principais, cada um com banco de dados próprio e comunicação via Kafka:

| Serviço | Porta | Descrição |
|--------|-------|------------|
| `wardrobe-service` | 8081 | Gerencia o guarda-roupa do bebê |
| `layette-service`  | 8082 | Permite criar e organizar a lista de enxoval |
| `exchange-service` | 8083 | Centraliza os eventos entre os serviços via Kafka |

---

## 📬 Comunicação assíncrona com Kafka

A troca de informações entre os serviços é feita via tópicos Kafka:

- `wardrobe-topic` – envia eventos do guarda-roupa
- `layette-topic` – envia eventos do enxoval

O serviço `exchange-service` consome e registra esses eventos.

---

## 🔍 Endpoints principais

- `GET /api/events` – Visualiza todos os eventos recebidos
- `POST /api/events` – Envia um evento manualmente (para simulação)

### Exemplo de JSON para envio:

```json
{
  "service": "wardrobe-service",
  "id": 1,
  "name": "Macacão Azul",
  "status": "DISPONÍVEL"
}

rtifique-se de ter o Docker e Docker Compose instalados.