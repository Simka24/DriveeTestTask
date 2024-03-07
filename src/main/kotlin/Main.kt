import kotlin.math.abs

/*Определил класс Orders, который представляет заказы.
У каждого заказа есть три свойства (from - откуда, to - куда, cost - стоимость заказа).
Comparable<Orders> это интерфейс который позволяет сравнивать переменные класса Orders между собой.
Далее функция compareTo сравнивает знаечения, учитывая разницы (this.to - this.from) и (other.to - other.from). Эти разницы были
определены, чтобы узнать расстояние между точкой А и точкой Б.
В функции main определил позицию курьера. Далее в переменной orders сделал список заказов.
В переменной sortedOrders применил функцию sortedBy, который сортирует по возрастанию. Далее вычитал из позиции А позицию курьера,
чтобы понять насколько курьер близок к точке А.
Чтобы пройтись по всем элементам заказа применил forEach и вывел результат*/

data class Orders(val from: Int, val to: Int, val cost: Int) : Comparable<Orders> {

    override fun compareTo(other: Orders): Int {
        return (this.to - this.from).compareTo(other.to - other.from)
    }

}

fun main() {

    print("Введите гео-позицию курьера: ")
    val courier = readln().toInt()

    val orders = listOf(
            Orders(12, 56, 68),
            Orders(123, 536, 368),
            Orders(222, 516, 354),
            Orders(15, 26, 2)
    )

    val sortedOrders = orders.sortedBy { abs(it.from - courier) }

    sortedOrders.forEach {
        println("Точка А: ${it.from}, Точка Б: ${it.to}, Стоимость заказа: ${it.cost}")
    }
}