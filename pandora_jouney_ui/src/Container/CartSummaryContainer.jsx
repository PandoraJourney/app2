import React, { Component } from 'react';
import CartSummaryComponent from '../Component/CartSummaryComponent'
import PropTypes from 'prop-types'
import axios from 'axios'
import '../../node_modules/bootstrap/dist/css/bootstrap.min.css'
// import picture from './samsung.jpg';


import {injector} from 'react-services-injector'

class CartSummaryContainer extends Component {
  constructor(props, context) {
    super(props, context);
    this.handleDetailsClick = this.handleDetailsClick.bind(this);
    this.state = { products: [] };
  }

  componentDidMount() {
    axios.get('/api/cart-details').then((response) => {
      this.setState({ products: response.data });
    });
  }

  handleDetailsClick(productId) {
    const {UserService} = injector.get();
    return (() => {
      this.context.router.push('/products/' + UserService.user()+'/'+ productId, { id: productId });
    });
  }

  render() {
    return (
      <div>
        <CartSummaryComponent/>
          </div>
    )
  }
}

CartSummaryContainer.contextTypes = {
  router: PropTypes.object.isRequired,
};

export default CartSummaryContainer;