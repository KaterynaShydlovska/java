function balancepoint(arr) {
    let rSum = 0;
    let lSum = 0;

    for (let i = 0; i < arr.length; i++) {
        lSum += arr[i]
        rSum = 0;
        for (let j = i + 1; j < arr.length; j++) {
            rSum += arr[j]
        }
        if (lSum === rSum) {
            return true;
        }
    }
    return false;
}


// balancepoint([1,2,3,4,10]) //true
// balancepoint([4,7,1,3]) //false
balancepoint([10, 2, 4, 8]) //true
    // balancepoint([10,8, 9, 1, 8]) //true
    // balancepoint([10,8, 9, 1, 8, 6]) //false
    // balancepoint([]) //false

//or 

function Balancepoint(arr) {
    let total = 0;
    let leftsum = 0;
    //first loop through to find total sum
    for (let i = 0; i < arr.length; i++) {
        total += arr[i]
    }

    //go through array again, and at each index (each iteration), add to left sum, then compare leftsum with total-leftsum, and if those ar  equal return true
    for (let i = 0; i < arr.length; i++) {
        leftsum += arr[i]
            //compare leftsum with total-leftsum, and if those ar  equal return true
        if (leftsum == (total - leftsum)) {
            return true
        }
    }
    return false
}
console.log(Balancepoint([1, 2, 3, 4, 10])) //true   
console.log(Balancepoint([4, 7, 1, 3])) //false

// total = 20
// leftsum = 10
// remaining(total-leftsum) -> 10

function binarySearch(arr, value) {
    let left = 0;
    let right = arr.length - 1;

    while (left < right) {
        let mid = Math.ceil((left + right) / 2)
        if (arr[mid] === value) {
            return true;
        } else if (arr[mid] < value) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    return false;
}

// binarySearch([5,8,9,15,17,23,24,34,77], 60) //false
// binarySearch([5,8,9,15,17,23,24,34,77], 34) //true


function recursiveBS(arr, x, start = 0, end = arr.length - 1) {
    if (start > end) return false;

    let mid = Math.floor((start + end) / 2);

    if (arr[mid] === x) return true;

    if (arr[mid] > x)
        return recursiveBS(arr, x, start, mid - 1);
    else
        return recursiveBS(arr, x, mid + 1, end);
}

recursiveBS([5, 8, 9, 15, 17, 23, 24, 77], 34);




function removeDupesTwoLoops(arr) {
    let obj = {};
    for (let i = 0; i < arr.length; i++) {
        if (!obj[arr[i]]) {
            obj[arr[i]] = 1;
        } else {
            obj[arr[i]] += 1;
        }
    }
    for (let j = 0; j < arr.length; j++) {
        if (obj[arr[j]] > 1) {
            obj[arr[j]] -= 1;
            arr.splice(j, 1);
        }
    }

    return arr;
}
removeDupesTwoLoops([4, 7, 8, 8, 4, 2, 3])

//or

function removeDupes(arr) {
    let obj = {};

    for (let i = 0; i < arr.length; i++) {
        if (!obj[arr[i]]) {
            obj[arr[i]] = 1;
        } else {
            arr.splice(i, 1);
            i--;
        }
    }
    return arr;
}
removeDupes([4, 7, 8, 8, 4, 2, 3])


//matrix

var big = [
    [67, 34, 45, 56],
    [98, 87, 76, 65],
    [56, 67, 78, 89],
    [54, 43, 32, 21]
]

var small = [
    [67, 78],
    [43, 32]
]

var anotherSmall = [
    [67, 7],
    [43, 32]
]

function matrixSearch(bigMatrix, smallMatrix) {
    for (let j = 0; j < bigMatrix.length; j++) {
        for (let k = 0; k < bigMatrix[j].length; k++) {
            if (smallMatrix[0][0] === bigMatrix[j][k]) {
                if (helper(bigMatrix, smallMatrix, j, k)) {
                    return true;
                }
            }
        }
    }
    return false;
}

function helper(bigMatrix, smallMatrix, j, k) {
    let a = j;
    let b = k;
    for (let i = 0; i < smallMatrix.length; i++) {
        for (let z = 0; z < smallMatrix[0].length; z++) {
            if (a >= bigMatrix.length || b >= bigMatrix[0].length) {
                return false;
            }
            if (smallMatrix[i][z] != bigMatrix[a][b]) {
                return false;
            }
            b++;
        }
        a++;
        b = k;
    }
    return true;
}

console.log(matrixSearch(big, small)) //true
console.log(matrixSearch(big, anotherSmall)) //false


class Node {
    constructor(valueinput) {
        this.value = valueinput;
        this.next = null;
    }
}


class SLL {
    constructor() {
        this.head = null;
    }

    addToBack(valueinput) {
        let newnode = new Node(valueinput);
        if (this.head == null) {
            this.head = newnode;
        } else {
            let runner = this.head;
            while (runner.next != null) {
                runner = runner.next
            }
            runner.next = newnode;

        }
    }

    display() {
        let runner = this.head;
        while (runner) {
            console.log(runner.value + " -->");
            runner = runner.next;
        }
    }

    reverse() {
        if (!this.head) {
            return "List is empty!"
        }
        let prev = null;
        let cur = this.head;
        let next = cur.next;

        while (next) {
            cur.next = prev;
            prev = cur;
            cur = next;
            next = next.next;
        }
        cur.next = prev;
        this.head = cur;
    }
}



let sll1 = new SLL();
sll1.addToBack(5);
sll1.addToBack(12);
sll1.addToBack(3);
// sll1.display()
sll1.reverse()
sll1.display()

class Node {
    constructor(valueinput) {
        this.value = valueinput;
        this.next = null;
        this.prev = null;
    }
}

class DLL {
    constructor() {
        this.head = null;
        this.tail = null;
    }

    //thursday
    addfront(valueInput) {
        let newNode = new Node(valueInput);
        if (!this.head) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head.prev = newNode;
            this.head = newNode;
        }

        return this;

    }

    //thursday
    addback(valueInput) {
        let newNode = new Node(valueInput);
        if (!this.head) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            newNode.prev = this.tail;
            this.tail = newNode;
        }


    }

    class Node {
        constructor(valueinput) {
            this.value = valueinput;
            this.next = null;
            this.prev = null;
        }
    }

    class DLL {
        constructor() {
                this.head = null;
                this.tail = null;
            }
            //thursday
        addfront(valueInput) {
            let newNode = new Node(valueInput);
            if (!this.head) {
                this.head = newNode;
                this.tail = newNode;
            } else {
                newNode.next = this.head;
                this.head.prev = newNode;
                this.head = newNode;
            }

            return this;

        }

        //thursday
        addback(valueInput) {
            let newNode = new Node(valueInput);
            if (!this.head) {
                this.head = newNode;
                this.tail = newNode;
            } else {
                this.tail.next = newNode;
                newNode.prev = this.tail;
                this.tail = newNode;
            }
            return this;


        }

        isHeadCorrect() {
            console.log(this.head.value)
            console.log(this.head.prev)
            console.log(this.head.next)



        }

        printValuesForward() {
            let runner = this.head;
            let result = ""
            while (runner != null) {
                result += `${runner.value}->`;

                runner = runner.next;
            }
            console.log(result);
            return this;
        }

        printValuesBackward() {
            let runner = this.tail;
            let result = ""
            while (runner != null) {
                result += `${runner.value}->`;
                runner = runner.prev;
            }
            console.log(result);
            return this;
        }


        //friday
        removefront() {
            if (!this.head) {
                return "Empty list!"
            } else {
                this.head = this.head.next;
                this.head.prev.next = this.head;
                this.head.prev = null;

            }

        }

        removeBack() {
            if (!this.head) {
                return "Empty list!"
            } else {
                this.tail.prev.next = null
                this.tail = this.tail.prev


            }


        }

        reverse() {
            let runner = this.head;
            let backward = this.tail;
            while (runner != backward && runner.prev != backward) {
                let temp = runner.value
                runner.value = backward.value
                backward.value = temp
                runner = runner.next
                backward = backward.prev
            }
            return this

        }


        recurseReverse(runner = this.head) {
            if (runner === null) {
                [this.head, this.tail] = [this.tail, this.head];
                return this;
            }
            [runner.prev, runner.next] = [runner.next, runner.prev];
            return this.recurseReverse(runner.prev);
        }



        display() {
            let runner = this.head;
            while (runner) {
                console.log(runner.value + " -->");
                runner = runner.next;
            }
        }

    }

    let dll = new DLL();

    dll.addfront(5);
    dll.addfront(15);
    dll.addback(2);
    dll.addback(20);
    dll.display()