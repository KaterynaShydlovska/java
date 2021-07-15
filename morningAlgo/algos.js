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


    class Node {
        constructor(value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }


    class BST {
        constructor() {
            this.root = null;
        }

        add(value) {
            let newNode = new Node(value);
            if (!this.root) {
                // console.log('here')
                this.root = newNode;
            } else {
                this.insert(this.root, newNode);
            }
            return this;
        }

        insert(node, newNode) {
            if (newNode.value > node.value) {
                if (!node.right) {
                    node.right = newNode;
                } else {
                    node.insert(node.left, newNode);
                }
            } else {
                if (!node.left) {
                    node.left = newNode;
                } else {
                    this.insert(node.left, newNode);
                }

            }

        }
    }



    let bst1 = new BST()
    bst1.add(12);
    bst1.add(10)
    bst1.add(11)
    console.log(bst1.add(20));


    class Node {
        constructor(value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }


    class BST {
        constructor() {
            this.root = null;
        }

        add(value) {
            //create a node
            let newNode = new Node(value)
            if (this.root == null) {
                this.root = newNode;
            } else {
                let runner = this.root;
                while (runner != null) {
                    if (value > runner.value) {
                        if (runner.right == null) {
                            runner.right = newNode;
                            break
                        } else {
                            runner = runner.right
                        }
                    } else if (value < runner.value) {
                        if (runner.left == null) {
                            runner.left = newNode;
                            break
                        } else {
                            runner = runner.left
                        }
                    } else {
                        console.log("no duplicates allowed in a BST")
                        return this;
                    }
                }
            }
            return this;
        }


        findMin() {
            let min = this.root.value;
            if (this.root.left) {
                let runner = this.root.left;
                while (runner) {
                    // console.log(runner, 'here')
                    if (runner.value < min) {
                        min = runner.value;
                        runner = runner.left;
                    }
                }

            }
            return min;
        }

        findMax() {
            let max = this.root.value;
            if (this.root.right) {
                let runner = this.root.right;
                while (runner) {
                    if (runner.value > max) {
                        max = runner.value;
                        runner = runner.right;
                    }
                }
            }
            return max;

        }

        printTree(node) {
            console.log("Current node = ", node.value);
            if (node.left != null) {
                console.log("left node of", node.value, "= " + node.left.value)
                this.printTree(node.left)
            }
            if (node.right != null) {
                console.log("Right node of", node.value, " = " + node.right.value)
                this.printTree(node.right);
            }
        }
        contains(value) {
            if (!this.root) {
                return "Empty!"
            }

            let runner = this.root;
            while (runner) {
                if (runner.value === value) {
                    return true;
                }
                if (runner.value > value) {
                    if (runner.left) {
                        runner = runner.left;
                    } else {
                        runner = null;
                    }
                } else {

                    if (runner.right) {
                        runner = runner.right;
                    } else {
                        runner = null;
                    }
                }

            }
            return false;
        }

        contains2(value) {
            if (this.root == null) {
                console.log("This tree is empty, it doesn't contain anything")
                return false
            } else {
                let current = this.root
                while (current != null) {
                    //if the value is in the current node
                    if (value == current.value) {
                        return true
                    } else if (value > current.value) {
                        current = current.right;
                    } else {
                        current = current.left;
                    }
                }
                return false
            }
        }

        size(node) {
            if (node == null) {
                console.log("no size");
                return false
            } else {
                return (this.size(node.left) + 1 + this.size(node.right))
            }
        }

        height(node) {
            if (node == null) {
                return 0
            } else {
                let leftHeight = this.height(node.left)
                let rightHeight = this.height(node.right)
                if (leftHeight > rightHeight) {
                    return leftHeight + 1
                } else {
                    return rightHeight + 1
                }
            }
        }

        height2(node) {
            let leftcount = 1
            let rightcount = 1
            if (node.right != null && node.left != null) { //we need to compare the lengths on the right and left
                rightcount += this.height(node.right)
                leftcount += this.height(node.left)
            } else if (node.right != null) {
                rightcount += this.height(node.right)
            } else if (node.left != null) {
                leftcount += this.height(node.left)
            }

            console.log("leftcount: ", leftcount);
            console.log("rightcount: ", rightcount)
            if (leftcount > rightcount) {
                return leftcount
            } else {
                return rightcount
            }
        }

        height3(node) {
            let left;
            let right;
            if (node == null) {
                return false
            } else {
                left = this.height(node.left) + 1;
                right = this.height(node.right) + 1;
            }
            if (left > right) {
                return left;
            } else {
                return right;
            }
        }
    }



    let bst1 = new BST()
    bst1.add(12).add(15).add(10).add(11).printTree(bst1.root)
    console.log('----------')
    console.log(bst1.findMin());
    console.log(bst1.findMax());


    class TrieNode {
        constructor(letter) {
            this.letter = letter;
            this.children = {};
            this.isWord = false
        }
    }

    class TrieSet {
        constructor() {
            this.root = new TrieNode("")
        }
        add(str) {
            //create a runner that allows us to navigate ourselves down this trie
            let runner = this.root;
            //loop through every character in the string
            for (let i = 0; i < str.length; i++) {
                // console.log(str[i])
                //if the children of the current node we are on does not contain a key for the letter we want to reference, then we need to create a new node that contains that letter and assign that node to this particular nodes children
                if (!runner.children.hasOwnProperty(str[i])) {
                    runner.children[str[i]] = new TrieNode(str[i]);
                }
                //move runner to the node for that new letter that got inserted
                runner = runner.children[str[i]]
            }
            //at this point, we have runner at the node that represents the end of a word/term 
            runner.isWord = true

        }

        printAllWords(root = this.root, str = "") {
            //base case
            if (root.isWord) {
                console.log(str)
            }

            //forward progress--> recurse through each child node, while passing a string that we build along the way
            for (const key in root.children) {
                this.printAllWords(root.children[key], str + key)
            }
        }




    }



    let words = new TrieSet();
    words.add("cab")
    words.add("can")
    words.add("cog")
    words.printAllWords()
        // words.add("dog")
        // words.add("cat")


    class TrieNode {
        constructor(letter) {
            this.letter = letter;
            this.children = {};
            this.isWord = false
        }
    }

    class TrieSet {
        constructor() {
            this.root = new TrieNode("")
        }
        add(str) {
            //create a runner that allows us to navigate ourselves down this trie
            let runner = this.root;
            //loop through every character in the string
            for (let i = 0; i < str.length; i++) {
                // console.log(str[i])
                //if the children of the current node we are on does not contain a key for the letter we want to reference, then we need to create a new node that contains that letter and assign that node to this particular nodes children
                if (!runner.children.hasOwnProperty(str[i])) {
                    runner.children[str[i]] = new TrieNode(str[i]);
                }
                //move runner to the node for that new letter that got inserted
                runner = runner.children[str[i]]
            }
            //at this point, we have runner at the node that represents the end of a word/term 
            runner.isWord = true

        }

        printAllWords(root = this.root, str = "") {
            //base case
            if (root.isWord) {
                console.log(str)
            }

            //forward progress--> recurse through each child node, while passing a string that we build along the way
            for (const key in root.children) {
                this.printAllWords(root.children[key], str + key)
            }
        }

        contains(str) {
            let runner = this.root;
            for (let i = 0; i < str.length && runner != null; ++i) {
                if (runner.children[str[i]] == null) return false;
                runner = runner.children[str[i]]
                console.log("RUNNER IS NOW THIS--->", runner)
            }
            if (runner.letter = str[str.length - 1] && runner.isWord) {
                return true;
            } else {
                return false;
            }
        }



    }



    let words = new TrieSet();
    words.add("cabbage")
    words.add("caboose")
    words.add("cabinet")
    words.add("dog")
    words.add("doggone")



    words.printAllWords()
    console.log(words.contains("cabbage")) //true
    console.log(words.contains("cab")) //false
    console.log(words.contains("weezy")) //false



    // words.add("dog")
    // words.add("cat")

    arr = [1, 4, 6, 8, 2, 10, 3, 5];

function swap(arr, index1, index2) {
  let temp = arr[index1];
  arr[index1] = arr[index2];
  arr[index2] = temp;
}


function bubleSort(arr) {
  for (let i = 0; i < arr.length; i++) {
    for (j = 0; j <= i; j++) {
      console.log(i, "i", j, "j");
      if (arr[i] < arr[j]) {
        console.log('swap')
        swap(arr, i, j);
      }
    }
  }
  return arr

};
bubleSort(arr);


function swap(arr, index1, index2) {
  let temp = arr[index1];
  arr[index1] = arr[index2];
  arr[index2] = temp;
}

function selectionSort(arr) {
  let min;
  for (var i = 0; i < arr.length; i++) {
    // set minimum to this position
    min = i;
    //check the rest of the array to see if anything is smaller
    for (j = i + 1; j < arr.length; j++) {
      if (arr[j] < arr[min]) {
        min = j;
      }
    }
    //if the minimum isn't in the position, swap it
    if (i != min) {
      swap(arr, i, min);
    }
  }

  return arr;
}
console.log(selectionSort([5,4,2,6,8,14,1,3]));

function selectionSort2(arr){
    for(let i = 0; i < arr.length; ++i){
        let mindex = i;
        for(let j = i; j < arr.length; ++j){
            if(arr[j] < arr[mindex]){
                mindex = j;
            }
        }
        let temp = arr[i];
        arr[i] = arr[mindex];
        arr[mindex] = temp;
    }
    return arr;
}

console.log(selectionSort2([5,4,2,6,8,14,1,3]));

//partition the array around the value at arr[0]
//without creating a new array
//values left of the original pivot should be less than the pivot
//values right of the pivot should be >= the pivot value
//note: each side of the partitioned value does not
//have to be sorted.
//return the newly partitioned array
//bonus: return the index where the value at 0 ends up
//[5,4,9,2,5,3] -> [4,2,3,5,9,5], return 3
const partition = (arr) => {
    let pivot = arr[0];
    let pointer = 0;

    for(let i = 1; i < arr.length; ++i){
        //if arr[i] < pivot
        if(arr[i] < pivot){
            ++pointer;

            let temp = arr[pointer];
            arr[pointer] = arr[i];
            arr[i] = temp;
        }
    }
    let temp = arr[0];
    arr[0] = arr[pointer];
    arr[pointer] = temp;
        
    console.log(arr);
    return pointer;

}

//should return [4,2,3,5,9,5]
console.log(partition([5,4,9,2,5,3]));
//should return [4,7]
console.log(partition([7,4]));
//should return [2,1,3,4,5]
console.log(partition([3,5,1,2,4]));

console.log(partition([7,2,10,15,1]));


//Remove duplicate characters(case-sensitive) including
//punctuation. Keep only the last instance of each character
//and don't you dare use built in functions for this one!
//"Snaps! crackles! pops!" -> "Snrackle ops!"
//scoop dedupe!
const dedupe = (str) => {
    let obj ={};
    let res =[];
    for(let i=0; i< str.length; i++){
        if(!obj[str[i]]){
          obj[str[i]] =1;
        }
        else{
           obj[str[i]] +=1;
        }
       
    }
    for(let j = str.length-1; j>=0; j--){
      console.log('here')
      if(obj[str[j]]){
        res.unshift(str[j]);
        delete obj[str[j]]
      }
    }
      console.log(res);
    return res.join('');
  }
  
  console.log(dedupe("Snaps! crackles! pops!"))
  //"Snaps! crackles! pops!" -> "Snrackle ops!"


  //You are given a string that may contain sequences of consecutive characters.
//Create a function to shorten a string by including the character, then the 
//number of times it appears. For "aaaabbcddd" return "a4b2c1d3"
//no built in functions!!!! parseInt() is ok
//gggag -> 3g1a1g
 
const encode = (str) => {
    let obj ={};
    let result ="";
    for(let i=0; i< str.length; i++){
      if(!obj[str[i]]){
        obj[str[i]] = 1;
      }else{
        obj[str[i]] += 1
      }
    }
    
  for(let j=0; j< str.length; j++){
    if(obj[str[j]]){
      result += str[j];
      result += obj[str[j]];
      j = j + obj[str[j]]-1;
    }
  }
   return result;
  }
  console.log(encode("aaabbcccc"));
  // console.log(encode("ddddeeeeeffgggg"));
  // console.log(encode("aaaaabbbbbbbc"));
  // console.log(encode("bb"));
  
  //given an encoded string, decode and return it
  //given "a3b2c1d3" return "aaabbcddd"
  //special note: can your function handle "g14f12"?
  const decode = (str) => {
    let counter;
    let i =0;
    let res ="";
  
    while(i< str.length){
      let j= parseInt(str[i+1])
      console.log(j)
      while(j>0){
        res+=str[i];
        j--;
      }
      i+=2;
    }
       return res;       
  }
  
  console.log(decode("a3b2c4"));
  // console.log(decode("t2h10j4"));



