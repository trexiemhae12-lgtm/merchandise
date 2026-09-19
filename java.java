import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.Desktop;

public class Main {

    public static void main(String[] args) {

        String html = """
<!DOCTYPE html>
<html>
<head>
    <title>Wizarding World Merchandise</title>

    <style>
        * {
            box-sizing: border-box;
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
        }

        body {
            background: #111;
            color: white;
        }

        header {
            background: #1b1b1b;
            padding: 20px;
            text-align: center;
            border-bottom: 3px solid #d4af37;
        }

        header h1 {
            color: #d4af37;
            font-size: 35px;
        }

        header p {
            color: #ddd;
            margin-top: 8px;
        }

        nav {
            margin-top: 15px;
        }

        nav button {
            background: #333;
            color: white;
            border: 1px solid #d4af37;
            padding: 10px 18px;
            margin: 5px;
            border-radius: 5px;
            cursor: pointer;
        }

        nav button:hover {
            background: #d4af37;
            color: black;
        }

        .hero {
            text-align: center;
            padding: 50px 20px;
            background: linear-gradient(135deg, #181818, #292929);
        }

        .hero h2 {
            font-size: 38px;
            color: #d4af37;
            margin-bottom: 15px;
        }

        .hero p {
            font-size: 18px;
            color: #ccc;
        }

        .shop {
            padding: 35px;
            max-width: 1100px;
            margin: auto;
        }

        .shop-title {
            text-align: center;
            color: #d4af37;
            margin-bottom: 25px;
            font-size: 30px;
        }

        .products {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(220px, 1fr));
            gap: 25px;
        }

        .product {
            background: #202020;
            border: 1px solid #444;
            border-radius: 10px;
            padding: 20px;
            text-align: center;
            transition: 0.3s;
        }

        .product:hover {
            transform: translateY(-7px);
            border-color: #d4af37;
        }

        .product-icon {
            font-size: 65px;
            margin-bottom: 15px;
        }

        .product h3 {
            color: #fff;
            margin-bottom: 10px;
        }

        .product p {
            color: #bbb;
            margin-bottom: 10px;
        }

        .price {
            color: #d4af37;
            font-size: 20px;
            font-weight: bold;
            margin-bottom: 15px;
        }

        .product button {
            background: #d4af37;
            border: none;
            padding: 10px 18px;
            border-radius: 5px;
            cursor: pointer;
            font-weight: bold;
        }

        .product button:hover {
            background: white;
        }

        .cart {
            background: #1b1b1b;
            border-top: 3px solid #d4af37;
            margin-top: 30px;
            padding: 30px;
            text-align: center;
        }

        .cart h2 {
            color: #d4af37;
            margin-bottom: 15px;
        }

        #cartItems {
            margin: 20px auto;
            max-width: 600px;
            text-align: left;
        }

        .cart-item {
            background: #292929;
            padding: 12px;
            margin: 8px;
            border-radius: 5px;
            display: flex;
            justify-content: space-between;
        }

        .remove {
            background: #8b0000;
            color: white;
            border: none;
            padding: 5px 10px;
            border-radius: 4px;
            cursor: pointer;
        }

        .checkout {
            background: #d4af37;
            color: black;
            border: none;
            padding: 12px 25px;
            border-radius: 5px;
            font-weight: bold;
            cursor: pointer;
        }

        .checkout:hover {
            background: white;
        }

        footer {
            text-align: center;
            padding: 20px;
            color: #888;
            background: #0b0b0b;
        }

        @media(max-width:600px) {
            .hero h2 {
                font-size: 28px;
            }

            .shop {
                padding: 20px;
            }
        }
    </style>
</head>

<body>

<header>
    <h1>⚡ Wizarding World Shop ⚡</h1>
    <p>Harry Potter Inspired Merchandise</p>

    <nav>
        <button onclick="showAll()">All Products</button>
        <button onclick="showHouse('Gryffindor')">Gryffindor</button>
        <button onclick="showHouse('Slytherin')">Slytherin</button>
        <button onclick="showHouse('Ravenclaw')">Ravenclaw</button>
        <button onclick="showHouse('Hufflepuff')">Hufflepuff</button>
    </nav>
</header>

<section class="hero">
    <h2>Welcome, Wizard!</h2>
    <p>Discover magical merchandise for every Hogwarts fan.</p>
</section>

<section class="shop">

    <h2 class="shop-title">Magical Merchandise</h2>

    <div class="products">

        <div class="product" data-house="Gryffindor">
            <div class="product-icon">🧣</div>
            <h3>Gryffindor Scarf</h3>
            <p>Show your Hogwarts house pride.</p>
            <div class="price">₱850</div>
            <button onclick="addToCart('Gryffindor Scarf', 850)">
                Add to Cart
            </button>
        </div>

        <div class="product" data-house="Slytherin">
            <div class="product-icon">🐍</div>
            <h3>Slytherin Mug</h3>
            <p>A magical mug for every Slytherin fan.</p>
            <div class="price">₱450</div>
            <button onclick="addToCart('Slytherin Mug', 450)">
                Add to Cart
            </button>
        </div>

        <div class="product" data-house="Ravenclaw">
            <div class="product-icon">🦅</div>
            <h3>Ravenclaw Notebook</h3>
            <p>Perfect for notes and magical ideas.</p>
            <div class="price">₱350</div>
            <button onclick="addToCart('Ravenclaw Notebook', 350)">
                Add to Cart
            </button>
        </div>

        <div class="product" data-house="Hufflepuff">
            <div class="product-icon">🦡</div>
            <h3>Hufflepuff Tote Bag</h3>
            <p>A simple bag for everyday adventures.</p>
            <div class="price">₱550</div>
            <button onclick="addToCart('Hufflepuff Tote Bag', 550)">
                Add to Cart
            </button>
        </div>

        <div class="product" data-house="Gryffindor">
            <div class="product-icon">🪄</div>
            <h3>Wizard Wand</h3>
            <p>A collectible magical wand.</p>
            <div class="price">₱1,200</div>
            <button onclick="addToCart('Wizard Wand', 1200)">
                Add to Cart
            </button>
        </div>

        <div class="product" data-house="Slytherin">
            <div class="product-icon">🧥</div>
            <h3>Slytherin Hoodie</h3>
            <p>Stay comfortable while showing your house.</p>
            <div class="price">₱1,500</div>
            <button onclick="addToCart('Slytherin Hoodie', 1500)">
                Add to Cart
            </button>
        </div>

    </div>

</section>

<section class="cart">

    <h2>🛒 Your Magical Cart</h2>

    <div id="cartItems">
        <p>Your cart is empty.</p>
    </div>

    <h3>Total: ₱<span id="total">0</span></h3>

    <br>

    <button class="checkout" onclick="checkout()">
        Checkout
    </button>

</section>

<footer>
    <p>© 2026 Wizarding World Shop | Harry Potter Inspired Website</p>
</footer>

<script>

let cart = [];
let total = 0;

function addToCart(name, price) {

    cart.push({
        name: name,
        price: price
    });

    total += price;

    updateCart();

    alert(name + " has been added to your cart!");
}

function updateCart() {

    let cartItems = document.getElementById("cartItems");

    cartItems.innerHTML = "";

    if (cart.length === 0) {

        cartItems.innerHTML = "<p>Your cart is empty.</p>";

    } else {

        cart.forEach(function(item, index) {

            let div = document.createElement("div");

            div.className = "cart-item";

            div.innerHTML =
                "<span>" + item.name +
                " - ₱" + item.price.toLocaleString() +
                "</span>" +
                "<button class='remove' onclick='removeItem(" +
                index + ")'>Remove</button>";

            cartItems.appendChild(div);
        });
    }

    document.getElementById("total").innerText =
        total.toLocaleString();
}

function removeItem(index) {

    total -= cart[index].price;

    cart.splice(index, 1);

    updateCart();
}

function checkout() {

    if (cart.length === 0) {

        alert("Your cart is empty!");

    } else {

        alert(
            "Thank you for your magical purchase! ⚡\\n\\n" +
            "Total: ₱" + total.toLocaleString()
        );

        cart = [];
        total = 0;

        updateCart();
    }
}

function showAll() {

    let products =
        document.querySelectorAll(".product");

    products.forEach(function(product) {
        product.style.display = "block";
    });
}

function showHouse(house) {

    let products =
        document.querySelectorAll(".product");

    products.forEach(function(product) {

        if (product.dataset.house === house) {
            product.style.display = "block";
        } else {
            product.style.display = "none";
        }

    });
}

</script>

</body>
</html>
""";

        try {

            File file = new File("HarryPotterShop.html");

            FileWriter writer = new FileWriter(file);

            writer.write(html);

            writer.close();

            System.out.println("Website created successfully!");

            Desktop.getDesktop().browse(file.toURI());

        } catch (IOException e) {

            System.out.println("Error: " + e.getMessage());

        }
    }
}