const router = require('express').Router();
const User = require('../model/user');

router.get('/test', (req, res) => {
    res.send("Hello");
});

router.post('/register', (req, res) => {
    const user = new User({
        username: req.body.username,
        password: req.body.password
    });

    try {
        user.save();
        res.send(user);
    } catch {
        res.sendStatus(400);
    }
});

router.post('/login', (req, res) => {
    const userName = req.body.username;
    const password = req.body.password;

    User.findOne({username: userName, password: password}, (err, user) => {
        if(err) {
            res.sendStatus(400);
            res.send(err);
        } else {
            res.send(user);
        }
    });
});

module.exports = router;