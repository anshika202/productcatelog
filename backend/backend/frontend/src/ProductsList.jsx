import React from 'react'

const ProductsList = ({ products }) => {
    return (
        <div className='row'>
            {products.map((item) => (
                <div className='col-lg-4 col-md-6 col-sm-12 mb-4' key={item.id}>
                    <div className='card h-100'>
                        <img
                            src={item.imgUrl || 'https://placehold.co/600x400'}
                            className='card-img-top'
                            alt={item.name}/>

                            <div className="card-body">
                                <h5 className="card-title">{item.name}</h5>
                                <p className="card-text">{item.description}</p>
                                <p className="card-text">${item.price}</p>
                                
                            </div>
                    </div>
                </div>
            ))}
        </div>
    )
}

export default ProductsList