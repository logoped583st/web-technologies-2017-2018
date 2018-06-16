const initialState = {
    image: '',
    name: '',
    login: '',
    bio: '',
    blog: '',
    company: '',
    location: '',
    email: '',
    social: ''
};


const reducer = (state = initialState, action) => {
    switch (action.type) {
        default:{
            return initialState;
        }
    }
};

export default reducer;