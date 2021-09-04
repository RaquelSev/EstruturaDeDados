import java.util.Arrays;

public class Vetor {
   
    private Aluno[] alunos = new Aluno[100];
    private int totalDeAlunos = 0;

    
    private void garanteEspaço() {
        if(totalDeAlunos == alunos.length){
            Aluno[] novoArray = new Aluno[alunos.length*2];
            for(int i = 0; i < alunos.length; i++) {
                novoArray[i] = alunos[i];
            }
            this.alunos = novoArray;
        }
    }
    
    public void adiciona(Aluno aluno) {
        this.garanteEspaço();
        //Solucao com tempo constante
        this.alunos[totalDeAlunos] = aluno;
        totalDeAlunos++;

        //Muito demorado
        // for(int i = 0; i < alunos.length; i++){
        //     if(alunos[i] == null){
        //         alunos[i] = aluno;
        //         break;
        //     }  
        // }


    }
    private boolean posicaoValida(int posicao) {

        return posicao >= 0 && posicao <= totalDeAlunos;

    }

    public void adiciona(int posicao, Aluno aluno) {
        this.garanteEspaço();

        if(posicaoValida(posicao)){
            
            throw new IllegalArgumentException("Posicao invalida");  
          }

        for(int i = totalDeAlunos - 1; i >= posicao; i-=1){
            alunos[i+1] = alunos[i];
        }

        alunos[posicao] = aluno;
        totalDeAlunos++;
    }

    private boolean posicaoOcupada (int posicao) {
        return posicao >= 0 && posicao < totalDeAlunos;
    }
    public Aluno pega(int posicao) { //Devolve o aluno que está naquela posicao da lista
        
        if(posicaoOcupada(posicao)) {
           throw new IllegalArgumentException("Posição inválida"); 
        }
        return alunos[posicao];
    }

    public void remove(int posicao) {

        for(int i = posicao; i < this.totalDeAlunos - 1; i++){
           this.alunos[i] = this.alunos[i+1];

        }
        totalDeAlunos--;
        this.alunos[totalDeAlunos] = null; //Libero espaço do último para a memória;
    }

    public boolean contem(Aluno aluno) {//aluno está ou não na lista
        for(int i = 0; i < totalDeAlunos; i++) { // i < total porque se for igual apontará para null
            if(aluno.equals(alunos[i])){
                return true;
            }
        }
        return false;
    }

    public int tamanho() {
        return totalDeAlunos;
    }

    public String toString() {
        return Arrays.toString(alunos);
    }
}
