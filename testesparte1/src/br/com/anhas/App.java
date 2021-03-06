package br.com.anhas;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    static Scanner scanner = new Scanner(System.in);

    static List<Pessoa> pessoas;
    static List<Pessoa> feminino;
    static String nomePessoa1;
    static String sexoPessoa1;
    static String nomePessoa2;
    static String sexoPessoa2;
    static String nomePessoa3;
    static String sexoPessoa3;

    static Pessoa pessoa1;
    static Pessoa pessoa2;
    static Pessoa pessoa3;

    public static void main(String[] args) {

        insersaoDados();
        instanciaPessoa();
        insersaoList();
        insersaoGrupo();

        System.out.println("Pessoas: " + pessoas);
        System.out.println(feminino);

//        lista();

    }

    public static void insersaoDados() {

        System.out.print("Digite o nome da primeira pessoa: ");
        nomePessoa1 = scanner.nextLine();

        System.out.print("Digite o sexo da primeira pessoa: ");
        sexoPessoa1 = scanner.nextLine();

        System.out.print("Digite o nome da segunda pessoa: ");
        nomePessoa2 = scanner.nextLine();

        System.out.print("Digite o sexo da segunda pessoa: ");
        sexoPessoa2 = scanner.nextLine();

        System.out.print("Digite o nome da terceira pessoa: ");
        nomePessoa3 = scanner.nextLine();

        System.out.print("Digite o sexo da terceira pessoa: ");
        sexoPessoa3 = scanner.nextLine();

    }

    public static void instanciaPessoa() {

        pessoa1 = new Pessoa(nomePessoa1, sexoPessoa1);
        pessoa2 = new Pessoa(nomePessoa2, sexoPessoa2);
        pessoa3 = new Pessoa(nomePessoa3, sexoPessoa3);

    }

    private static void insersaoList() {

        pessoas = new ArrayList<>();
        pessoas.add(pessoa1);
        pessoas.add(pessoa2);
        pessoas.add(pessoa3);

    }

    private static void insersaoGrupo() {

        feminino = new ArrayList<>();

        GrupoPessoas grupoPessoas = (pessoas) -> {

            for (Pessoa pessoa: pessoas) {

                if (pessoa.getSexo().equals("feminino")){

                    feminino.add(pessoa);

                }

            }

        };

        grupoPessoas.analise(pessoas);

    }

    public static void lista(){

        for (Pessoa pessoa: feminino) {

            System.out.println(pessoa.getSexo());

        }

    }

    @Test
    public void testeListaFeminino() {

        List<Pessoa> femininoTeste = new ArrayList<>();
        Pessoa pessoaTeste1 = new Pessoa("Maria", "feminino");
        Pessoa pessoaTeste2 = new Pessoa("Joao", "masculino");

        femininoTeste.add(pessoaTeste1);
        femininoTeste.add(pessoaTeste2);

        for (Pessoa pessoa: femininoTeste) {

            Assert.assertEquals("feminino", pessoa.getSexo());

        }

    }
}