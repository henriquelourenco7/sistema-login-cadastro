import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterLink } from '@angular/router';
import { Auth } from '../services/auth';

@Component({
  imports: [FormsModule, RouterLink],
  selector: 'app-login',
  styleUrl: './login.css',
  templateUrl: './login.html',
})
export class Login {

constructor(private auth: Auth) {}
  
mensagem = 'Entre com seus dados para continuar';

email = '';
senha = '';

entrar() {
  if (!this.email || !this.senha) {
    alert('Preencha o e-mail e a senha.');
    return;
  }

  this.auth.login(this.email, this.senha).subscribe((resposta) => {
    console.log(resposta);
  })
}
}
