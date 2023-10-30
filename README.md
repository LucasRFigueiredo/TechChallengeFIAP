<h1 align="center">TechChallenge Fiap - Restaurante</h1>

<p align="center">
  <a href="#-license">
    <img alt="License" src="https://img.shields.io/static/v1?label=license&message=MIT&color=ed2945&labelColor=000000">
  </a>
</p>

## Projeto

Projeto voltado para o fluxo de um restaurante, desde a fase de pedidos até o inicio da fila com um fakecheckout, 

## Tecnologia

This project was built using the following technologies and architectural concepts:

- [Java](https://www.java.com/pt-BR/)
- [Docker](https://www.docker.com/)
- [DDD (Domain-driven Design)](https://domainlanguage.com/)
- [Hexagonal Architecture](<https://en.wikipedia.org/wiki/Hexagonal_architecture_(software)>)

## 🟢 Running

Prerequisites: Ensure you have `docker`, `node>=18.16.0` & `npm>=9.5.1` installed.

1. Clone this project:

```sh
git clone https://github.com/tribofustack/orderly.git
```

2. Configure your environment by creating a `.env` file based on the `.env.production`.

3. Start the application:

```sh
npm run start:docker
```

This will launch the application at port `3000`.

Once it's up, the Swagger documentation can be accessed at `http://localhost:3000/`.



## DDD (Domain-Driven Design)



### Event Storming

<div align="center">
  <img src="./.github/event-storming.png" alt="Event Storming" />
</div>

### Context Map

<div align="center">
  <img src="./.github/context-map.png" alt="Context Map" />
</div>

## 📝 License

This project is licensed under the MIT License. For more information, please refer to the [LICENSE](LICENSE.md) file.
