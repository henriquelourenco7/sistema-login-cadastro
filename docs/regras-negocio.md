# Regras de Negocio

### RN01 - Email unico

Cada email deve pertencer a apenas um usuario.

### RN02 - Telefone unico

Cada telefone deve pertencer a apenas um usuario.

### RN03 - Senha

A senha deve possuir no minimo 8 caracteres, uma letra maiuscula, um numero e um caractere especial.

### RN04 - Data de nascimento

A data de nascimento deve ser anterior a data atual.

### RN05 - Data de nascimento imutavel

O usuario nao podera alterar sua data de nascimento depois do cadastro.

### RN06 - Usuario comum

Todo novo cadastro deve criar um usuario comum.

### RN07 - Administrador

Um usuario so podera ser administrador quando essa permissao for definida diretamente no banco de dados.

### RN08 - Usuario bloqueado

Um usuario bloqueado nao podera realizar login.

### RN09 - Usuario banido

Um usuario banido nao podera realizar login.

### RN10 - Bloqueio

Apenas administradores podem bloquear ou desbloquear usuarios comuns.

### RN11 - Banimento

Apenas administradores podem banir ou desbanir usuarios comuns.

### RN12 - Administradores

Um administrador nao podera bloquear, desbloquear, banir ou desbanir outro administrador.

### RN13 - Alteracao de dados

Um usuario logado podera alterar seu email, telefone e senha.

### RN14 - Senha atual

Para alterar a senha, o usuario devera informar sua senha atual.

### RN15 - Status da conta

O bloqueio ou banimento nao devera apagar o cadastro do usuario do banco de dados.
