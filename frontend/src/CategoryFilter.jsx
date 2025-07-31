import React from 'react'

const CategoryFilter = ({categories, onSelect}) => {
    console.log("categories ---->", categories)
  return (
    <>
        <select id='categorySelect' className='form-control' onChange={(e) => onSelect(e.target.value)}>
            <option value="">
                All Categories
            </option>
            {categories.map(item => (
                <option key={item.id} value={item.id}>{item.name}</option>
            ))}
         </select>
    </>
  )
}

export default CategoryFilter