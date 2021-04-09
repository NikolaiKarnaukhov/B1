package com.javacourse.stack;


public class IntegerStack {

	private int arraySize = 10;

	private Integer[] stackArray;

	public String arrayName;

	private int head;

	/**
	 * Конструктор без аргументов должен создаавать валидный стек
	 */
	public IntegerStack(){
		stackArray = new Integer[arraySize];
		head = -1;
	}

	/**
	 * Добавляет новый элемент в стек, учтите следующее при реализации:
	 * 1) каждый следующий вызов добавляет новый элемент на верх стека.
	 * 2) реализация должна позволять добавлять null-value элементы в стек.
	 *
	 * @param item добавляемый целочисленный элемент
	 */
	public void push(Integer item) {
		if(head != arraySize - 1) {
			head++;
			stackArray[head] = item;
		}
		else{
			arraySize++;
			Integer[] newArray = new Integer[arraySize];
			System.arraycopy(stackArray,0,newArray,0,arraySize);
			stackArray = new Integer[arraySize];
			System.arraycopy(newArray,0,stackArray,0,arraySize);
		}

		throw new RuntimeException("Method not implemented");

	}

	/**
	 * Извлекает из стека последний добавленный элемент, при реализации учтите что:
	 * 1) элементы стека извлекаются методом `pop` в порядке обратном порядку добавления их туда.
	 * 2) после вызова этого метода в стеке становится на один элемент меньше.
	 * 3) если в стеке нет элементов, то вызов этого метода приводит к броску исключения
	 * типа RuntimeException с текстом сообщения "Empty Stack Exception".
	 *
	 * @return значение элемента который был извлечен из стека
	 */
	public Integer pop() {
		if(head != -1){
			head--;
			return stackArray[head];
		}
		else throw new RuntimeException("Method not implemented");
	}

	/**
	 * Вызов этого метода дает возможность посмотреть значение на верхушке стека,
	 * не извлекая элемент из него. При реализации учтите следующие моменты:
	 * 1) вызов метода peek не должен влиять на порядок элементов стека и его состояние
	 * 2) если peek вызван на пустом стеке, то это приводит к броску исключения
	 * типа RuntimeException с текстом сообщения "Empty Stack Exception"
	 * 3) peek может вернуть `null` если до этого на вершину стека был помещен
	 * элемент со значением `null`.
	 *
	 * @return значение элемента на вершине стека
	 */
	public Integer peek() {
		if(head != -1) {return stackArray[head];}
		else throw new RuntimeException("Method not implemented");
	}
}
