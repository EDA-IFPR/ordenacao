package mergesort;

import java.util.Arrays;

public class MergeSort {
    public static int[] mergeSort(int[] array, int zero, int fim) {
        if (zero < fim) {
            int meio = (zero + fim) / 2;

            mergeSort(array, zero, meio);
            mergeSort(array, meio + 1, fim);
            mergeia(array, zero, meio, fim);
        }
        return array;
    }

    // mergeia dois subarrays de array[]
    // o primeiro é da  esquerda (array[0]) até o array[meio]
    // o segundo é do array[meio + 1] até o array[fim]
    public static void mergeia(int[] array, int comeco, int meio, int fim) {
        int tamanhoArrayEsquerdo = meio - comeco + 1;
        int tamanhoArrayDireito = fim - meio;

        int[] tempArrayEsquerdo = new int[tamanhoArrayEsquerdo];
        int[] tempArrayDireito = new int[tamanhoArrayDireito];

        for (int i = 0; i < tamanhoArrayEsquerdo; i++) {
            tempArrayEsquerdo[i] = array[comeco + i];
        }

        for (int i = 0; i < tamanhoArrayDireito; i++) {
            tempArrayDireito[i] = array[meio + 1 + i];
        }

        int i = 0; // pro esquerdo
        int j = 0; // pro direito
        int k = comeco; // comeco subarray q vai ser mergeado

        // mergeando as duas metades no array original
        while (i < tamanhoArrayEsquerdo && j < tamanhoArrayDireito) {

            // se essa casa em específico do array esquerdo for menor, entra primeiro no array original
            if (tempArrayEsquerdo[i] <= tempArrayDireito[j]) {
                array[k] = tempArrayEsquerdo[i];
                i++;
            } else {
                array[k] = tempArrayDireito[j];
                j++;
            }
            k++;
        }
        //uma das metades ainda vai ter valores, vamos copiar elas p array original

        while (i < tamanhoArrayEsquerdo) {
            array[k] = tempArrayEsquerdo[i];
            i++;
            k++;
        }

        while (j < tamanhoArrayDireito) {
            array[k] = tempArrayDireito[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(mergeSort(new int[]{1, 5, 11, 4, 16, 0, 7}, 0, 6)));
    }
}
