import { useEffect, useState } from 'react'
import './App.css'
import ProductsList from './ProductsList';
import CategoryFilter from './CategoryFilter';

function App() {
  const [products, setProducts] = useState([]);
  const [categories, setCategories] = useState([]);
  const [selectedCategory, setSelectedCategory] = useState(null);
  const [searchTerm, setSearchTerm] = useState(null);
  const [sortOrder, setSortOrder] = useState("asc");

   useEffect(() => {
    fetch('http://localhost:8080/api/categories')
      .then((response) => response.json())
      .then(data => setCategories(data));
  },[]);

  useEffect(() => {
    fetch('http://localhost:8080/api/products')
      .then((response) => response.json())
      .then(data => setProducts(data));
  },[]);

  const handleSearch = (event) => {
    setSearchTerm(event.target.value);
  }

  const handleSortChange = (event) => {
    setSortOrder(event.target.value);
  }

  const handleCategorySelect = (id) => {
    setSelectedCategory(id ? Number(id): null);
  }

  useEffect(() => {
    console.log("id --->", selectedCategory);
  },[selectedCategory])
useEffect(() => {
  console.log("products --->", products.map(p => ({
    name: p.name,
    categoryId: p.category?.id
  })));
}, [products]);

  const filteredProducts = products
  .filter((item) => {
    const matchesCategory = selectedCategory
      ? item.category?.id === selectedCategory
      : true;

    const matchesSearch = searchTerm
      ? item.name.toLowerCase().includes(searchTerm.toLowerCase())
      : true;

    return matchesCategory && matchesSearch;
  })
  .sort((a, b) => {
    return sortOrder === "asc"
      ? a.price - b.price
      : b.price - a.price;
  });


  return (
    <div className='container'>
    <h1 className='my-4'>Product Catalog</h1>

    <div className='row align-items-center mb-4'>
      <div className='col-md-3 col-sm-13 mb-12'>
        <CategoryFilter categories={categories} onSelect={handleCategorySelect}/>
      </div>

      <div className='col-md-5 col-sm-12 mb-12'>
        <input
        type='text'
        className='form-control'
        placeholder='Search Products'
        onChange={ handleSearch}/>
      </div>

      <div className='col-md-3 col-sm-12 mb-2'>
        <select className='form-control' onChange={handleSortChange}>
          <option value="asc">Sort by Price : Low to High</option>
          <option value="desc">Sort by Price : High to Low</option>
        </select>
      </div>

    </div>
      <div>
        {filteredProducts.length ? 
        (
          <div>
            <ProductsList products={filteredProducts}/>
          </div>
        ) 
        :
        (
          <div>NO products not found</div>
        )
        }
      </div>
      
    </div>
  )
}

export default App
