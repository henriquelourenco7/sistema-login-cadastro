# Casos de Uso

## Usuario comum

### UC01 - Cadastrar usuario

**Ator:** Usuario

**Objetivo:** Criar uma conta no sistema.

**Resultado esperado:** Uma nova conta de usuario comum e criada.

### UC02 - Fazer login

**Ator:** Usuario

**Objetivo:** Entrar no sistema utilizando email e senha.

**Resultado esperado:** Usuario autenticado.

### UC03 - Recuperar senha

**Ator:** Usuario

**Objetivo:** Recuperar o acesso a conta quando esquecer a senha.

**Resultado esperado:** Usuario consegue definir uma nova senha.

### UC04 - Alterar email

**Ator:** Usuario autenticado

**Objetivo:** Alterar o email da propria conta.

**Resultado esperado:** Email atualizado.

### UC05 - Alterar telefone

**Ator:** Usuario autenticado

**Objetivo:** Alterar o telefone da propria conta.

**Resultado esperado:** Telefone atualizado.

### UC06 - Alterar senha

**Ator:** Usuario autenticado

**Objetivo:** Alterar a propria senha.

**Resultado esperado:** Senha atualizada.

---

## Administrador

### UC07 - Bloquear usuario

**Ator:** Administrador

**Objetivo:** Impedir temporariamente que um usuario comum faca login.

**Resultado esperado:** Usuario fica bloqueado.

### UC08 - Desbloquear usuario

**Ator:** Administrador

**Objetivo:** Permitir novamente o acesso de um usuario bloqueado.

**Resultado esperado:** Usuario fica ativo novamente.

### UC09 - Banir usuario

**Ator:** Administrador

**Objetivo:** Impedir o acesso de um usuario comum ate que um administrador realize o desbanimento.

**Resultado esperado:** Usuario fica banido.

### UC10 - Desbanir usuario

**Ator:** Administrador

**Objetivo:** Permitir novamente o acesso de um usuario banido.

**Resultado esperado:** Usuario volta a ter acesso ao sistema.
