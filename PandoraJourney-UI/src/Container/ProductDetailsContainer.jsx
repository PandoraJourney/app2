import React, { Component } from 'react'
import ProductDetailsComponent from '../Component/ProductDetailsComponent'
import '../../node_modules/bootstrap/dist/css/bootstrap.min.css'
import axios from 'axios'
import PropTypes from 'prop-types'

class ProductDetailsContainer extends Component {
  constructor(context, props) {
    super(context, props)
    this.handleAddToCart = this.handleAddToCart.bind(this);
    this.handleBack = this.handleBack.bind(this);
    this.state = { product: "" };
  }

  componentWillMount() {
    var index = this.props.params.id - 1;
    axios.get('https://itpro2017.herokuapp.com/api/products').then((response) => {
      this.setState({ product: response.data[index] });
    });
  }

  handleAddToCart() {
    var body = {
      id: this.state.product.id,
      image: this.state.product.image,
      title: this.state.product.title
    };
    // axios.post('/api/users/' + UserService.getUsername() + '/cart-products', body).then(function() {
      axios.post('/api/cart-products', body).then(()=>{});
   }

  handleBack() {
    return (this.context.router.goBack());
  }

  render() {
    return (
      <ProductDetailsComponent product={this.state.product} onAddToCart={this.handelAddToCart} onBack={this.handleBack} />
    );
  }
};

ProductDetailsContainer.contextTypes = {
  router: PropTypes.object.isRequired,
};


export default ProductDetailsContainer;