# Singleton

Esse padrão de projeto é utilizado quando se deseja criar um apenas uma instância da classe. Ele pode ser utilizado, por exemplo, em sistemas de login ou sistemas de segurança. 

Primeiramente, os atributos estáticos, ou seja, ele pertence à classe, e não ao objeto. Assim, 

Construtor privado impede que elementos externos instaciem objetos do tipo Singleton, o que pode causar erro de compilação. Como somente haverá manipulação do construtor pela própria classe, precisamos de um atributo que também será estático 


```java

package padroes;

public class Singleton {
	private Singleton() {
	}

	private static Singleton instance;

	private static Singleton getSingleton() {
		if (instance == null) {
			instance = new Singleton();
		}
		return instance;

	}

	public void login() {

	}

}
```
