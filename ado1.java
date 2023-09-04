import java.util.Random;
import java.util.Scanner;

class ado1 {

    static int[] array = new int[0];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int menu = 0;

        while (menu != 9) {
            System.out.println();
            System.out.println("1 - Inicializar o vetor com números aleatórios");
            System.out.println("2 - Imprimir o vetor");
            System.out.println("3 - Verificar se um determinado número está contido nesse vetor");
            System.out.println("4 - Buscar o maior número armazenado no vetor");
            System.out.println("5 - Calcular a média dos números pares armazenados no vetor");
            System.out.println("6 - Calcular o percentual dos números ímpares armazenados no vetor");
            System.out.println("7 - Calcula a média centralizada dos números armazenados no vetor");
            System.out.println(
                    "8 - Verificar se, dado um valor, existe dois números em posições distintas que somados é igual ao valor informado por parâmetro");
            System.out.println("9 - Encerrar");
            System.out.print("Opção: ");
            menu = sc.nextInt();
            System.out.println(); // quebra de linha

            switch (menu) {
                case 1:
                    System.out.print("Digite o tamanho do Vetor: ");
                    int tamVetor = sc.nextInt();
                    System.out.print("Deseja gerar quantos números ? (menor ou igual): ");
                    int rangeNumeros = sc.nextInt();
                    Random rd = new Random();
                    array = new int[tamVetor];
                    for (int i = 0; i < array.length; i++) {
                        array[i] = rd.nextInt(rangeNumeros + 1);
                    }
                    break;
                case 2:
                    if (array.length == 0) {
                        System.out.println("Vetor vazio! ");
                        continue;
                    }
                    imprimirVetor();

                    break;
                case 3:
                    if (array.length == 0) {
                        System.out.println("Vetor vazio! ");
                        continue;
                    }
                    System.out.print("Informe um valor a ser procurado no vetor: ");
                    int valor = sc.nextInt();
                    int result = verificaNum(array, valor);
                    if (result == -1) {
                        System.out.println("Valor não encontrado.");
                    } else {
                        System.out.printf("Valor encontrado no índice : %d\n", result);
                    }
                    break;
                case 4:
                    if (array.length == 0) {
                        System.out.println("Vetor vazio! ");
                        continue;
                    }
                    System.out.printf("Maior elemento do vetor: %d\n", buscaMaiorVetor(array));
                    break;
                case 5:
                    if (array.length == 0) {
                        System.out.println("Vetor vazio! ");
                        continue;
                    }

                    System.out.printf("Média dos números pares: %.2f\n", calcMediaPar(array));
                    break;
                case 6:
                    if (array.length == 0) {
                        System.out.println("Vetor vazio! ");
                        continue;
                    }
                    System.out.printf("Percentual dos números Ímpares: %.1f%%\n", percentualImpar(array));
                    break;
                case 7:
                    if (array.length == 0) {
                        System.out.println("Vetor vazio! ");
                        continue;
                    }
                    System.out.printf("Valor da média centralizada: %.2f\n", mediaCentralizada(array));
                    break;
                case 8:
                    if (array.length == 0) {
                        System.out.println("Vetor vazio! ");
                        continue;
                    }
                    System.out.print("Informe um valor que deseja consultar: ");
                    int num = sc.nextInt();
                    boolean teste = verifSomaIguais(array, num);

                    if (teste) {
                        System.out.println("Existe!");
                    } else {
                        System.out.println("Não existe!");
                    }

                    break;
                case 9:
                    System.out.println("Você saiu.");
                    break;
                default:
                    System.out.println("Opção Inválida.");
                    break;
            }
        }
        sc.close();
    }

    // Imprime o vetor na tela.
    static void imprimirVetor() {

        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    // Verificar se um determinado número está contido no vetor.
    static int verificaNum(int[] array, int valor) {
        int indice = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == valor) {
                indice = i;
                break;
            }
        }
        return indice;
    }

    // Buscar o maior número armazenado no vetor.
    static int buscaMaiorVetor(int[] array) {
        int maior = array[0];
        for (int i : array) {
            if (i > maior) {
                maior = i;
            }
        }
        return maior;
    }

    // Calcular a média dos números pares armazenados no vetor.
    static Double calcMediaPar(int[] array) {
        double soma = 0;
        int cont = 0;
        for (int i : array) {
            if (i % 2 == 0) {
                soma += i;
                cont++;
            }
        }

        return soma / cont;
    }

    // Calcular o percentual dos números ímpares armazenados no vetor.
    static Double percentualImpar(int[] array) {
        int cont = 0;
        for (int i : array) {
            if (i % 2 != 0) {
                cont++;
            }
        }
        return (double)cont / array.length * 100;
    }

    // Calcula a média centralizada dos números armazenados no vetor:
    static Double mediaCentralizada(int[] array) {
        int menor = array[0];
        int maior = array[0];
        double soma = 0;
        int cont = 0;

        for (int i : array) {
            if (i < menor) {
                menor = i;
            } else if (i > maior) {
                maior = i;
            }
        }

        for (int i : array) {
            if (i == menor) {
                menor = -1;
                continue;
            } else if (i == maior) {
                maior = -1;
                continue;
            }
            soma += i;
            cont++;
        }
        return soma / cont;
    }

    // Verificar se, dado um valor, existe dois números em posições distintas que
    // somados é igual ao valor informado por parâmetro
    static boolean verifSomaIguais(int[] array, int num) {
        boolean teste = false;
        int[] arrayDup = array;

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 1; j < array.length; j++) {
                if (array[i] + arrayDup[j] == num) {
                    return true;
                }
            }
        }
        return teste;
    }

}