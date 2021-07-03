package com.javacourse.stack;

import java.net.InetSocketAddress;

public class IntegerStack {

	private int arraySize = 0;
	private int head;
	private int difference = 10;
	private Integer minElem, maxElem;

	private Integer[] stackArray;
	private Integer[] trackMin;
	private Integer[] trackMax;

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
			head++;

			stackArray = new Integer[arraySize];
			trackMin = new Integer[arraySize];
			trackMax = new Integer[arraySize];

			stackArray[0] = item;
			trackMin[0] = item;
			trackMax[0] =item;

			minElem = stackArray[0];
			maxElem = stackArray[0];
		}
		else {
			if (head != arraySize - 1) {
				head++;
				stackArray[head] = item;

				if (item != null) {
					if (item > maxElem) {
						maxElem = item;
						trackMax[head] = maxElem;
					} else {
						trackMax[head] = maxElem;
					}

					if(item < minElem){
						minElem = item;
						trackMin[head] = minElem;
					}
					else{
						trackMin[head] = minElem;
					}
				}
				else{
					trackMin[head] = minElem;
					trackMax[head] = maxElem;
				}
			}
			else {
				head++;
				arraySize = arraySize + difference;

				Integer[] newArray = new Integer[arraySize];
				Integer[] newtrackMax = new Integer[arraySize];
				Integer[] newtrackMin = new Integer[arraySize];

				System.arraycopy(stackArray, 0, newArray, 0, arraySize - difference);
				System.arraycopy(trackMax, 0,newtrackMax,0,arraySize - difference);
				System.arraycopy(trackMin, 0,newtrackMin,0,arraySize - difference);

				stackArray = null;
				trackMax = null;
				trackMin = null;

				newArray[head] = item;
				if (item != null) {
					if (item > maxElem) {
						maxElem = item;
						newtrackMax[head] = maxElem;
					} else {
						newtrackMax[head] = maxElem;
					}

					if(item < minElem){
						minElem = item;
						newtrackMin[head] = minElem;
					}
					else{
						newtrackMin[head] = minElem;
					}
				}
				else{
					newtrackMin[head] = minElem;
					newtrackMax[head] = maxElem;
				}

				stackArray = newArray;
				trackMax = newtrackMax;
				trackMin = newtrackMin;

			}
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
			head--;

			Integer temp = stackArray[0];

			stackArray = null;
			trackMax = null;
			trackMin = null;

			minElem = null;
			maxElem = null;


			return  temp;
		}
		else{
			Integer temp = stackArray[head];
			head--;

			if(arraySize % difference == 0)
			{
				arraySize--;

				Integer[] newArray = new Integer[arraySize];
				Integer[] newtrackMax = new Integer[arraySize];
				Integer[] newtrackMin = new Integer[arraySize];

				System.arraycopy(stackArray,0,newArray,0,arraySize);
				System.arraycopy(trackMax,0,newtrackMax,0,arraySize);
				System.arraycopy(trackMin,0,newtrackMin,0,arraySize);

				stackArray = null;
				trackMax = null;
				trackMin = null;

				stackArray = newArray;
				trackMax = newtrackMax;
				trackMin = newtrackMin;

				maxElem = trackMax[head];
				minElem = trackMin[head];
				return temp;
			}
			else{
				arraySize--;

				maxElem = trackMax[head];
				minElem = trackMin[head];

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
