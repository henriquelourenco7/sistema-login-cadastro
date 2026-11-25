import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

export interface LoginResponse{
    mensagem: string;
    nome: string;
    token: string;
}

@Injectable({
  providedIn: 'root'
})
export class Auth {

    private apiUrl = 'http://localhost:8080';

    constructor(private http:HttpClient) {}

    login(email: string, senha: string) {
        return this.http.post<LoginResponse>(`${this.apiUrl}/login`, {email, senha}) ;
    }
}