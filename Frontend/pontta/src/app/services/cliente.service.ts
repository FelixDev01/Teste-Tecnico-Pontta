import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Cliente } from '../models/cliente';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  private apiUrl = "http://localhost:8080/clientes"

  constructor(private http: HttpClient) { }

  criar(cliente: Cliente): Observable<Cliente>{
    return this.http.post<Cliente>(`${this.apiUrl}`, cliente)
  }

  listar(): Observable<{content: Cliente[]}>{
    return this.http.get<{content: Cliente[]}>(this.apiUrl)
  }

  listarUm(id: number): Observable<Cliente>{
    return this.http.get<Cliente>(`${this.apiUrl}/${id}`)
  }

  atualizar(cliente: Cliente): Observable<Cliente>{
    return this.http.put<Cliente>(`${this.apiUrl}/${cliente.id}`, cliente)
  }

  deletar(id: number): Observable<void>{
    return this.http.delete<void>(`${this.apiUrl}/${id}`)
  }
}
