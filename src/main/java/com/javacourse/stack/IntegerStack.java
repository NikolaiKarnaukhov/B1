package com.javacourse.stack;


public class IntegerStack {

	private int arraySize = 0;
	private Integer[] stackArray;
	private int head;
	private int difference = 10;
	private Integer minElem, maxElem;

	/**
	 * Конструктор без аргументов должен создаавать валидный стек
	 */
	public IntegerStack(){
		stackArray = new Integer[arraySize];
		head = -1;
	}

	public  int min(){
		return minElem;
	}

	public int max(){
		return maxElem;
	}

	/**
	 * Добавляет новый элемент в стек, учтите следующее при реализации:
	 * 1) каждый следующий вызов добавляет новый элемент на верх стека.
	 * 2) реализация должна позволять добавлять null-value элементы в стек.
	 *
	 * @param item добавляемый целочисленный элемент
	 */

	public void push(Integer item) {
		if(head == -1){
			arraySize++;
			stackArray = new Integer[arraySize];
			stackArray[0] = item;
			minElem = stackArray[0];
			maxElem = stackArray[0];
		}
		if(head != arraySize - 1) {
			head++;
			stackArray[head] = item;
			if (item != null) {
				if (item > maxElem) {
					maxElem = item;
				}
				if (item < minElem) {
					minElem = item;
				}
			}
		}
		else{
			if (item != null) {
				if (item > maxElem) {
					maxElem = item;
				}
				if (item < minElem) {
					minElem = item;
				}
			}
			head++;
			arraySize = arraySize + difference;
			Integer[] newArray = new Integer[arraySize];
			System.arraycopy(stackArray,0,newArray,0,arraySize - difference );
			stackArray = null;
			newArray[head] = item;
			stackArray = newArray;

		}
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
		if (head == -1) {
			throw new RuntimeException("Empty Stack Exception");
		}
		if (head == 0) {
			arraySize--;
			head --;
			Integer temp = stackArray[0];
			stackArray = null;
			minElem = null;
			maxElem = null;
			return  temp;
		}
		else{
			Integer temp = stackArray[head];
			head--;

			if(temp == maxElem || temp == minElem){
				if(temp == maxElem) maxElem = stackArray[0];
				if(temp == minElem) minElem = stackArray[0];

				for(int i=0; i<head+1;i++){
					if(stackArray[i] == null) continue;
					else{
						if(stackArray[i]>maxElem) maxElem = stackArray[i];
						if(stackArray[i]<minElem) minElem = stackArray[i];
					}
				}
			}

			if(arraySize % difference == 0)
			{
				arraySize--;
				Integer[] newArray = new Integer[arraySize];
				System.arraycopy(stackArray,0,newArray,0,arraySize);
				stackArray = null;
				stackArray = newArray;
				return temp;
			}
			else{
				arraySize--;
				return temp;
			}
		}
	}

	/**
	 * 1Вызов этого метода дает возможность посмотреть значение на верхушке стека,
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
		else throw new RuntimeException("Empty Stack Exception");
	}

}
