INSERT INTO public.applicationuser(
	email, firstname, isadmin, lastname, password)
	VALUES ('test@gmail.com', 'lorin', true, 'fankhauser', 'password123');

INSERT INTO public.applicationuser(
	email, firstname, isadmin, lastname, password)
	VALUES ('test2@gmail.com', 'Max', false, 'Mustermann', 'max123');

INSERT INTO public.booking(
	bookeddate, halfday, wholeday, user_id)
	VALUES ('2019-01-21T05:47:08.644', true, false, 1);

INSERT INTO public.booking(
	bookeddate, halfday, wholeday, user_id)
	VALUES ('2019-01-21T05:47:08.644', true, false, 2);

INSERT INTO public.booking(
	bookeddate, halfday, wholeday, user_id)
	VALUES ('2019-01-21T05:47:08.644', true, false, 2);

INSERT INTO public.booking(
	bookeddate, halfday, wholeday, user_id)
	VALUES ('2019-01-21T05:47:08.644', false, true, 2);

INSERT INTO public.coffee(
	"time", user_id)
	VALUES ('2019-01-21T05:47:08.644', 1);

INSERT INTO public.lunch(
	name, supplier, user_id)
	VALUES ('pizza', 'PizzaHut', 1);

INSERT INTO public.material(
	name, user_id)
	VALUES ('usb type C charger_1', 1);