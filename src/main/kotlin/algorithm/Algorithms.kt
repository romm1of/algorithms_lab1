package algorithm

fun <T> Array<T>.selectionSort(comparator: Comparator<T>) {
    val n: Int = this.size
    for (i in 0 until n - 1) {
        var minIndex = i
        for (j in i + 1 until n) {
            if (comparator.compare(this[j], this[minIndex]) == -1) {
                minIndex = j
            }
        }
        val temp = this[minIndex]
        this[minIndex] = this[i]
        this[i] = temp
    }
}

fun <T> Array<T>.quickSort(low: Int = 0, high: Int = this.size - 1, comparator: Comparator<T>) {
    if (low < high) {
        val pivot = partition(low, high, comparator)
        quickSort(low, pivot - 1, comparator)
        quickSort(pivot + 1, high, comparator)
    }
}

fun <T> Array<T>.partition(low: Int, high: Int, comparator: Comparator<T>): Int {
    val pivot = this[high]
    var i = low - 1
    for (j in low until high) {
        if (comparator.compare(this[j], pivot) == -1) {
            i++
            val temp = this[i]
            this[i] = this[j]
            this[j] = temp
        }
    }
    val temp = this[i + 1]
    this[i + 1] = this[high]
    this[high] = temp
    return i + 1
}