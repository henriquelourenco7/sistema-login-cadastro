# Sistema de Login e Cadastro

## 1. Visao geral

Sistema web criado para demonstrar um sistema de cadastro, login e controle de usuarios.

O projeto sera desenvolvido com:

* Frontend: HTML, CSS e JavaScript
* Backend: Java e Spring Boot
* Banco de dados: MySQL

## 2. Objetivo

Criar um sistema funcional de cadastro e autenticacao de usuarios, permitindo tambem o gerenciamento de usuarios por administradores.

## 3. Usuarios do sistema

O sistema tera dois tipos de usuarios:

### Usuario comum

Pode:

* Criar uma conta
* Fazer login
* Recuperar senha
* Alterar email
* Alterar telefone
* Alterar senha

### Administrador

Pode:

* Fazer login
* Recuperar senha
* Alterar seus proprios dados permitidos
* Bloquear usuarios comuns
* Desbloquear usuarios comuns
* Banir usuarios comuns
* Desbanir usuarios comuns

## 4. Dados do usuario

Cada usuario tera:

* ID
* Nome
* Email
* Telefone
* Senha
* Data de nascimento
* Tipo de usuario
* Status da conta

## 5. Escopo da primeira versao

A primeira versao tera:

* Cadastro
* Login
* Recuperacao de senha
* Alteracao de dados
* Bloqueio de usuarios
* Banimento de usuarios
* Controle de acesso entre usuario comum e administrador
* Interface web
* API REST
* Banco de dados MySQL

## 6. Futuras versoes

Poderao ser adicionados futuramente:

* Recuperacao de senha por token enviado por email
* Foto de perfil
* Historico de acoes administrativas
* Novas funcionalidades para administradores
* Melhorias de seguranca
