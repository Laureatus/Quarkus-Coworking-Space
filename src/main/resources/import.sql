INSERT INTO public.applicationuser(
	id, email, firstname, isadmin, lastname, password)
	VALUES (1, 'test@gmail.com', 'lorin', true, 'fankhauser', 'password123');

INSERT INTO public.applicationuser(
	id, email, firstname, isadmin, lastname, password)
	VALUES (2, 'test2@gmail.com', 'Max', false, 'Mustermann', 'max123');

INSERT INTO public.booking(
	id, bookeddate, halfday, wholeday, user_id)
	VALUES (1, '2019-01-21T05:47:08.644', true, false, 1);

INSERT INTO public.booking(
	id, bookeddate, halfday, wholeday, user_id)
	VALUES (2, '2019-01-21T05:47:08.644', true, false, 2);

INSERT INTO public.booking(
	id, bookeddate, halfday, wholeday, user_id)
	VALUES (2, '2019-01-21T05:47:08.644', true, false, 2);

INSERT INTO public.booking(
	id, bookeddate, halfday, wholeday, user_id)
	VALUES (2, '2019-01-21T05:47:08.644', false, true, 2);

INSERT INTO public.coffee(
	id, "time", user_id)
	VALUES (1, '2019-01-21T05:47:08.644', 1);

INSERT INTO public.lunch(
	id, name, supplier, user_id)
	VALUES (1, 'pizza', 'PizzaHut', 1);

INSERT INTO public.material(
	id, name, user_id)
	VALUES (1, 'usb type C charger_1', 1);