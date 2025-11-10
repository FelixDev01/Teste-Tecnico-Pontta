import { Component, OnInit } from '@angular/core';
import { Cliente } from '../../models/cliente';
import { ClienteService } from '../../services/cliente.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-cliente',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './cliente.component.html',
  styleUrl: './cliente.component.css'
})
export class ClienteComponent implements OnInit {

clientes: Cliente[] = [];
novoCliente: Cliente = {nome: "", email: ""};
idBusca: number | null = null;
clienteEditando: Cliente | null = null;
clienteBuscando: Cliente | null = null;

  constructor(private service: ClienteService){}
  ngOnInit(): void {
    this.atualizaLista()
  }

  atualizaLista() {
    this.service.listar().subscribe({
      next: (res)=>{
        console.log(res)
      }
    })
  }


  adicionar(){
    if(!this.novoCliente.nome || !this.novoCliente.email) return;
    this.service.criar(this.novoCliente).subscribe({
      next: () => {
      this.novoCliente = {nome: "", email: ""}
      this.atualizaLista();
    }
    })

  }


  buscarPorId() {
    if(!this.idBusca) return
    this.service.listarUm(this.idBusca).subscribe({
      next: (res) => (this.clienteBuscando = res),
      error: (err) => {
      console.error("Erro ao buscar CLIENTE", err);
      }
    })


  }

  salvarEdicao() {
    if(!this.clienteEditando?.id) return;
    this.service.atualizar(this.clienteEditando).subscribe({
      next : () => {
        alert('Cliente')
        this.clienteEditando = null;
        this.atualizaLista();
      }
    })
  }

  editar(cliente: Cliente){
    this.clienteEditando ={...cliente};
  }

  cancelarEdicao(){
    this.clienteEditando = null
  }

  deletar(id: number) {
    if (id === undefined) return;
    this.service.deletar(id).subscribe(() => this.atualizaLista())
  }
}
