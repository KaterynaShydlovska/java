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