package com.example.bancodigitalfake

import java.lang.StringBuilder
import java.util.*


fun main() {
    val sc = Scanner(System.`in`)

    print("Insira o nome do titular: ")
    val nome = readln()

    println("Insira o código da sua conta, 1 para pf e 2 para pj")
    val codConta = sc.nextInt()

    if (codConta == 1) {
        println("Tipo da conta: PESSOA_FISICA")
    } else if (codConta == 2) {
        println("Tipo da conta: PESSOA_JURIDICA")
    }

    print("Insira o cpf do titular: ")
    val cpfUsuario = sc.nextLong()

    print("Cadastre uma senha: ")
    var senhaCadastro = readln()
//    senhaCadastro.replace('a', '@',true)
    println(senhaCadastro)

    val contaUsuario = Cadastro(nome, cpfUsuario, codConta, senhaCadastro)

    println("Valor inicial da sua conta: " + contaUsuario.saldo)

    print("Insira o valor que deseja depositar: ")
    var depositar = sc.nextDouble()

    while (depositar <= 0) {
        println("O valor de deposito precisa ser maior que 0")
        print("Insira o valor que deseja depositar: ")
        depositar = sc.nextDouble()
    };if (depositar > 0) {
        contaUsuario.deposita(depositar)
    }

    println("O valor atual da sua conta é: " + contaUsuario.saldo)

    print("Insira o valor que deseja sacar: ")
    var sacar = sc.nextDouble()

    while (sacar <= 0) {
        println("O valor de saque precisa ser maior que 0")
        print("Insira o valor que deseja sacar: ")
        sacar = sc.nextDouble()
    };if (sacar > 0) {
        contaUsuario.saque(sacar)
    }
    println(
        "Titular da conta: " + contaUsuario.titular +
                "\nO valor atual da sua conta é: " + contaUsuario.saldo
    )
}


class Cadastro(var titular: String, var cpf: Long, var tipoConta: Int, var senha: String) {
    var saldo = 0.0
    var alfabeto = listOf("a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z")

    fun converterSenha() {
        senha.replace("a", "@")
    }

    fun deposita(valor: Double) {
        if (valor > 0) {
            this.saldo += valor
        }
    }

    fun saque(valor: Double) {
        if (saldo >= valor) {
            saldo -= valor
        } else {
            print("O valor de saque deve ser menor ou igual ao valor atual da sua conta")
        }
    }
}



