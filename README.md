# Factory Method

Padrão de Projeto Factory Method em Java
Descrição:
O padrão de projeto Factory Method define uma interface (ou um método abstrato) para criar objetos, mas permite que as
subclasses alterem o tipo
de objetos que serão criados. Isso permite que você isole a lógica de criação de objetos em uma única classe, o que pode
tornar seu código mais flexível e reutilizável.

Exemplo:
Considere um aplicativo que precisa criar diferentes tipos de documentos, como PDF, Word e HTML. Cada tipo de documento
tem sua própria classe e lógica de criação.

Interface *Documento*:

```java
public interface Documento {
    void imprimir();
}
```

Classe *PDF*:

```java
public class PDF implements Documento {
    @Override
    public void imprimir() {
        System.out.println("Imprimindo PDF...");
    }
}
```

Classe *Word*:

```java
public class Word implements Documento {
    @Override
    public void imprimir() {
        System.out.println("Imprimindo Word...");
    }
}
```

Classe *HTML*:

```java
public class HTML implements Documento {
    @Override
    public void imprimir() {
        System.out.println("Imprimindo HTML...");
    }
}

```

Classe *Word*:

```java
package designpatterns;

public class FabricaDocumentos {
    public Documento criarDocumento(String tipo) {
        if (tipo.equals("pdf")) {
            return new PDF();
        } else if (tipo.equals("word")) {
            return new Word();
        } else if (tipo.equals("html")) {
            return new HTML();
        } else {
            throw new IllegalArgumentException("Tipo de documento inválido");
        }
    }
}

```

Classe *Principal*:

```java

import designpatterns.FabricaDocumentos;

public class Main {
    public static void main (String[]args){
        FabricaDocumentos fabrica = new FabricaDocumentos();
        Documento documento = fabrica.criarDocumento("pdf");
        documento.imprimir();
    }
}
```



Benefícios:

* Encapsula a lógica de criação de objetos em uma única classe.
* Torna o código mais flexível e reutilizável.
* Permite adicionar novos tipos de objetos sem modificar o código existente.
  Desvantagens:
* Pode aumentar a complexidade do código.
* Pode ser difícil de entender se o código não estiver bem documentado.

O diagrama de classe que pode representar a implementação acima pode ser representada pela figura abaixo:

![img.png](img.png)