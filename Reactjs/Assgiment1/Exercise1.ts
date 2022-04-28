// Destructuring

// Array
let date: number[] = [10, 3, 2018];
let [, month, year] = date;
console.log(month);
console.log(year);

// Object 
let Person = {
    firstname: "Nguyen Minh",
    lastname: "Anh",
    age: "25"
};

let { firstname: f, lastname: l, age: a } = Person;
console.log(f);
console.log(l);
console.log(a);

//  Template String 
// STRING 
let fullName: String = "Le Van Tung";
let Age: number = 23;
let infomation = `Tôi tên là ${fullName} năm nay tôi  ${Age} tuổi `;
console.log(infomation);

// NUMBER
let c: number = 5;
let b: number = 20;

let sums = `Tổng của ${a} và ${b} là ${a + b}`;
console.log(sums);


let textes = [  '1.Chả giò nón lá',
                '2.Bò lúc lắc hạt điều',
                '3.Cá tai tượng chiên xù',
                '3.Cá tai tượng chiên xù',
                '4.Cải thìa sốt thịt cua',
                '5.Cơm chiên cá mận',
                '6.Lẩu hài sản']

console.log(textes);

// ...operator
let numbers: number[] = [2, 4, 6, 8, 10]
let newNumber: number[] = [...numbers, 1, 3, 5, 7, 9];
console.log(newNumber);

// String
let cold: String[] = ["autumn ", "winter"];
let warm: String[] = ['spring ', 'summer'];
let seasons: String[] = [...cold, ...warm];
console.log(seasons);

// Arrow Function 
let sum = (a) => a + 100;
let result = sum(5);
console.log(result);

// a)
let max =(a, b ) => a + b + 100;
let tong = max(5 ,6 );
console.log(tong);
// b)
let sum1 = (a , b) => {
    let check = 42;
    return a + b + check;
}
let result1 = sum1( 5, 6);
console.log(result1);

// Parameter
let multiply = (...numbers) =>{
    let result2 = 1 ; 
    numbers.forEach(element=>{
        result2 *= element;
    });
    return result2;
}
console.log(multiply(5));
console.log(multiply(5 ,3 ));
console.log(multiply(5 , 3 ,2 ));












